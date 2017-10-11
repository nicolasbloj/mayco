package com.nab.mayco.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.nab.mayco.dto.UserDTO;

@Service
public class AuthService {

  @Autowired
  private PasswordEncoder passwordEncoder;

  public boolean auth(UserDTO userFromLoggin, UserDTO userFromDB) {
    if (userFromDB != null) {
      if (passwordEncoder.matches(userFromLoggin.getPassword(), userFromDB.getPassword())) {
        return true;
      }
    }
    return false;
  }

}
