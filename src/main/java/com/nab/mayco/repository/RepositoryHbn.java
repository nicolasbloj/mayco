package com.nab.mayco.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



public abstract class RepositoryHbn<PK extends Serializable, E> implements Repository<PK, E> {

  @PersistenceContext
  private EntityManager entityManager;


  @SuppressWarnings("unchecked")
  @Override
  public List<E> list() {
    Class<E> persistentClass;
    persistentClass =
        (Class<E>) ((java.lang.reflect.ParameterizedType) this.getClass().getGenericSuperclass())
            .getActualTypeArguments()[1];
    String hql = "FROM " + persistentClass.getName();
    return (List<E>) entityManager.createQuery(hql).getResultList();
  }

  @Override
  public E add(E e) {
    entityManager.persist(e);
    entityManager.flush();
    return e;
  }

  @Override
  public E delete(E e) {
    entityManager.remove(entityManager.contains(e) ? e : entityManager.merge(e));
    // entityManager.remove(skill);
    entityManager.flush();
    return e;
  }

  public EntityManager getEntityManager() {
    return entityManager;
  }



}
