package com.nab.mayco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nab.mayco.dto.ProjectDTO;
import com.nab.mayco.model.Project;
import com.nab.mayco.repository.ProjectRepository;
import com.nab.mayco.util.ProjectConverter;

// @Transactional

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService {

  @Autowired
  @Qualifier("ProjectRepositoryHbn")
  private ProjectRepository projectReposityory;

  @Override
  public List<ProjectDTO> list() {
    List<ProjectDTO> projectsDTO = new ArrayList<ProjectDTO>();

    for (Project project : this.projectReposityory.list()) {
      projectsDTO.add(ProjectConverter.convertToDTO(project));

    }
    return projectsDTO;
  }

  @Override
  public void add(ProjectDTO projectDTO) {
    this.projectReposityory.add(ProjectConverter.convertFromDTO(projectDTO));
  }

}
