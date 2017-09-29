package com.nab.mayco.dto;

import java.io.Serializable;

public class ProjectDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer id;

  private String name;

  private Byte[] imageDecoded;

  private String imageEncoded;

  public ProjectDTO() {}

  // for delete
  public ProjectDTO(Integer id) {
    this.id = id;
  }

  public ProjectDTO(Integer id, String name) {
    this.name = name;
    this.id = id;
  }

  public ProjectDTO(String name) {
    this.name = name;
  }

  public ProjectDTO(String name, Byte[] imageDecoded) {
    this.name = name;
    this.imageDecoded = imageDecoded;
  }


  public ProjectDTO(Integer id, String name, String imageEncoded) {
    this.id = id;
    this.name = name;
    this.imageEncoded = imageEncoded;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Byte[] getImageDecoded() {
    return imageDecoded;
  }

  public String getImageEncoded() {
    return imageEncoded;
  }


}
