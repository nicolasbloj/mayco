package com.nab.mayco.repository;

import java.util.List;

import com.nab.mayco.model.Project;

public interface ProjectRepository {

  public Project delete(Project project);

  public void add(Project project); // Este metodo deberia devolver id

  public List<Project> list();

}
