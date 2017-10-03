package com.nab.mayco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nab.mayco.model.Mail;
import com.nab.mayco.service.MailService;

@RestController
@RequestMapping("/mail")
@CrossOrigin
public class MailController {

  @Autowired
  public MailService mailService;

  // {"to":"nicolasbloj@gmail.com","subject":"MAYCO-SUBJECT","text":"MAYCO-TEXT ...."}

  @RequestMapping(value = {"/send"}, method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> send(@RequestBody Mail mailObject) {

    if (mailService.send(mailObject)) {
      return new ResponseEntity<String>("El mail enviado correctamente.", HttpStatus.OK);
    } else {
      return new ResponseEntity<String>("El mail no pudo ser enviado.", HttpStatus.CONFLICT);
    }
  }
}
