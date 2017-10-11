package com.nab.mayco.repository;

import com.nab.mayco.model.User;

public interface UserRepository extends Repository<Integer, User> {

  public User getUserByUserName(String username);
}
