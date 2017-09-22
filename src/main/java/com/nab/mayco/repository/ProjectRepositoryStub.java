package com.nab.mayco.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.Project;

@Repository("ProjectRepositoryStub")
public class ProjectRepositoryStub implements ProjectRepository {

  @Override
  public List<Project> list() {
    List<Project> projects = new ArrayList<Project>();
    projects.add(new Project(1, "Proyecto numero 1"));
    projects.add(new Project(2, "Proyecto numero 2"));
    projects.add(new Project(3, "Proyecto numero 3"));
    projects.add(new Project(4, "Proyecto numero 4"));
    projects.add(new Project(5, "Proyecto numero 5"));
    return projects;
  }

  @Override
  public void add(Project project) {
    // TODO Auto-generated method stub

  }

}
