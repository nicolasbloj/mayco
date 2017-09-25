package com.nab.mayco;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.springframework.test.util.ReflectionTestUtils;

import com.nab.mayco.repository.ProjectRepository;
import com.nab.mayco.repository.ProjectRepositoryHbn;
import com.nab.mayco.service.ProjectService;
import com.nab.mayco.service.ProjectServiceImpl;


public class ProjectServiceUnitTest {


  private Logger logger = Logger.getLogger(ProjectServiceUnitTest.class);

  private ProjectService service;

  private ProjectRepository repositoryMock;

  @Before
  public void setUp() {
    repositoryMock = new ProjectRepositoryHbn();

    service = new ProjectServiceImpl();


    repositoryMock = org.mockito.Mockito.mock(ProjectRepository.class);

    ReflectionTestUtils.setField(service, "repository", repositoryMock);

    logger.info("Wow! I'm configured!");


  }



}
