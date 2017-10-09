package com.nab.mayco.util;

import com.nab.mayco.dto.UserDTO;
import com.nab.mayco.model.User;


public class UserConverter {


  public static UserDTO convertToDTO(User user) {
    if (user != null) {
      return new UserDTO(user.getId(), user.getName(), user.getUsername(), user.getPassword());
    }
    return null;
  }

  public static User convertFromDTO(UserDTO userDTO) {
    if (userDTO.getId() != null)
      return new User(userDTO.getId(), userDTO.getName(), userDTO.getUsername(),
          userDTO.getPassword());

    return new User(userDTO.getName(), userDTO.getUsername(), userDTO.getPassword());

  }

}
