package com.nab.mayco.repository;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.User;

@Transactional
@Repository("UserRepositoryHbn")
public class UserRepositoryHbn extends RepositoryHbn<Integer, User> implements UserRepository {

  // mejorar este metodo
  @Override
  public User getUserByUserName(String username) {
    String hql = "FROM User where username = ?1";
    @SuppressWarnings("unchecked")
    List<Query> list = getEntityManager().createQuery(hql).setParameter(1, username)
        .setMaxResults(1).getResultList();
    if (!list.isEmpty()) {
      return (User) list.get(0);
    }
    return null;
  }

}
