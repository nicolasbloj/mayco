package com.nab.mayco.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
@CrossOrigin
public class HelloController {

  @RequestMapping("/")
  public String hello() {
    return "Hello World ... nicolas";
  }

  @RequestMapping("/bye")
  public String goodBye() {
    return "Goodbye World ... heroku ...";
  }

}
