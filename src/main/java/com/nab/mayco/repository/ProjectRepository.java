package com.nab.mayco.repository;

import java.util.List;

import com.nab.mayco.model.Project;

public interface ProjectRepository {

  public void add(Project project);

  public List<Project> list();

}
