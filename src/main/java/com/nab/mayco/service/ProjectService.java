package com.nab.mayco.service;

import java.util.List;

import com.nab.mayco.dto.ProjectDTO;

public interface ProjectService {

  public void add(ProjectDTO projectDTO);

  public List<ProjectDTO> list();

}
