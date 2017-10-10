package com.nab.mayco.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nab.mayco.dto.UserDTO;
import com.nab.mayco.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

  private Logger logger = Logger.getAnonymousLogger();

  @Autowired
  UserService service;

  @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<UserDTO> login(@RequestBody UserDTO userDTOLogging) {

    UserDTO userDTO = service.login(userDTOLogging);


    if (userDTO != null)
      return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    else
      return new ResponseEntity<UserDTO>(userDTO, HttpStatus.NO_CONTENT);


  }

  @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> add(@RequestBody UserDTO userDTO) {
    service.add(userDTO);
    return new ResponseEntity<String>("Usuario cargado correctamente", HttpStatus.CREATED);
  }



}
