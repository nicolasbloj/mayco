package com.nab.mayco.service;

import java.util.List;

import com.nab.mayco.dto.ProjectDTO;

public interface ProjectService {

  public Integer delete(ProjectDTO projectDTO);

  public void add(ProjectDTO projectDTO); // Deberiamos devolver id

  public List<ProjectDTO> list();

}
