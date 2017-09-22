package com.nab.mayco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nab.mayco.model.Project;
import com.nab.mayco.repository.ProjectRepository;

// @Transactional

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  @Qualifier("ProjectRepositoryHbn")
  private ProjectRepository projectReposityory;

  @Override
  public List<Project> list() {
    return this.projectReposityory.list();
  }

  @Override
  public void add(Project project) {
    this.projectReposityory.add(project);
  }

}
