package com.nab.mayco.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.Skill;


@Transactional
@Repository("SkillRepositoryHbn")
public class SkillRepositoryHbn implements SkillRepository {

  @PersistenceContext
  private EntityManager entityManager;

  @SuppressWarnings("unchecked")
  @Override
  public List<Skill> list() {
    String hql = "FROM Skill";
    return (List<Skill>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public void add(Skill skill) {
    entityManager.persist(skill);
  }

  @Override
  public Skill delete(Skill skill) {
    entityManager.remove(entityManager.contains(skill) ? skill : entityManager.merge(skill));
    // entityManager.remove(skill);
    entityManager.flush();
    return skill;
  }


}
