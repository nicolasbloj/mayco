package com.nab.mayco.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String username;

  private String password;

  public UserDTO() {}

  public UserDTO(Integer id) {
    this.id = id;
  }

  public UserDTO(String username, String password) {
    this.username = username;
    this.password = password;
  }


  public UserDTO(String name, String username, String password) {
    this.name = name;
    this.username = username;
    this.password = password;
  }

  public UserDTO(Integer id, String name, String username, String password) {
    this.id = id;
    this.name = name;
    this.username = username;
    this.password = password;
  }

  public Integer getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }


  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }


}
