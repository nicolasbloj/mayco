package com.nab.mayco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.Project;

@Transactional
@Repository("ProjectRepositoryHbn")
public class ProjectRepositoryHbn implements ProjectRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Project> list() {
    String hql = "FROM Project";
    return (List<Project>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public void add(Project project) {
    entityManager.persist(project);
  }


  public Project delete(Project project) {
    entityManager.remove(entityManager.contains(project) ? project : entityManager.merge(project));
    // entityManager.remove(project);
    entityManager.flush();
    return project;
  }

}
