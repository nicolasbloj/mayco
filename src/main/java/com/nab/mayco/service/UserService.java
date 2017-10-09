package com.nab.mayco.service;

import java.util.List;

import com.nab.mayco.dto.UserDTO;

public interface UserService {

  public List<UserDTO> list();

  public void add(UserDTO userDTO);

  public Integer delete(UserDTO userDTO);

  public UserDTO login(UserDTO userDTOLogging);

}
