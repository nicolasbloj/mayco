package com.nab.mayco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.mayco.model.Project;
import com.nab.mayco.service.ProjectService;

@RestController
@RequestMapping("/project")
public class ProjectController {

  @Autowired
  @Qualifier("ProjectService")
  ProjectService service;

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<Project>> list() {
    List<Project> projects = service.list();
    return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
  }


}
