package com.nab.mayco.dto;

import java.io.Serializable;

public class ProjectDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private String description;

  private Byte[] imageDecoded;

  private String imageEncoded;

  public ProjectDTO() {}

  // for delete
  public ProjectDTO(Integer id) {
    this.id = id;
  }

  public ProjectDTO(Integer id, String name, String description) {
    this.name = name;
    this.id = id;
    this.description = description;
  }

  public ProjectDTO(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public ProjectDTO(String name, String description, Byte[] imageDecoded) {
    this.name = name;
    this.description = description;
    this.imageDecoded = imageDecoded;
  }


  public ProjectDTO(Integer id, String name, String description, String imageEncoded) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.imageEncoded = imageEncoded;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public Byte[] getImageDecoded() {
    return imageDecoded;
  }

  public String getImageEncoded() {
    return imageEncoded;
  }


}
