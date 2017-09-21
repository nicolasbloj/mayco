package com.nab.mayco.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.Project;

@Repository("ProjectRepositoryHbn")
public class ProjectRepositoryHbn implements ProjectRepository {

  @Override
  public List<Project> list() {
    // TODO Auto-generated method stub
    return null;
  }

}
