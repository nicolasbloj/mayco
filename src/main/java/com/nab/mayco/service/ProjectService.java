package com.nab.mayco.service;

import java.util.List;

import com.nab.mayco.model.Project;


public interface ProjectService {

  public void add(Project project);

  public List<Project> list();

}
