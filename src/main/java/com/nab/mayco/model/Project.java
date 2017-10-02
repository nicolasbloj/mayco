package com.nab.mayco.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class Project implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "project_id")
  private Integer id;

  // Podriamos poner validaciones como NOT_NULL, etc
  @Column(name = "name")
  private String name;

  @Column(name = "description")
  private String description;

  @Column(name = "image")
  private byte[] image;

  public Project() {}

  public Project(Integer id, String name, String description) {
    this.name = name;
    this.id = id;
    this.description = description;
  }

  public Project(String name, String description) {
    this.name = name;
    this.description = description;
  }

  public Project(String name, String description, byte[] image) {
    this.name = name;
    this.image = image;
    this.description = description;
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

  public byte[] getImage() {
    return image;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }


}
