package com.nab.mayco.dto;

public class SkillDTO {

  private Integer id;

  private String name;

  private String description;


  public SkillDTO() {}


  public SkillDTO(Integer id) {
    this.id = id;
  }

  public SkillDTO(Integer id, String name, String description) {
    this.name = name;
    this.id = id;
    this.description = description;
  }

  public SkillDTO(String name, String description) {
    this.name = name;
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

}
