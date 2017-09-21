package com.nab.mayco.model;

public class Project {

  private Integer id;

  private String name;

  // Byte [] img

  public Project(Integer id, String name) {
    this.name = name;
    this.id = id;
  }

  public Project(String name) {
    this.name = name;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }



}
