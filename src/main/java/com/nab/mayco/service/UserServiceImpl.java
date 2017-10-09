package com.nab.mayco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nab.mayco.dto.UserDTO;
import com.nab.mayco.model.User;
import com.nab.mayco.repository.UserRepository;
import com.nab.mayco.util.UserConverter;

@Transactional
@Service
public class UserServiceImpl implements UserService {

  // private Logger logger = Logger.getAnonymousLogger();

  @Autowired
  @Qualifier("UserRepositoryHbn")
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  public List<UserDTO> list() {
    List<UserDTO> usersDTO = new ArrayList<UserDTO>();

    for (User user : userRepository.list()) {
      usersDTO.add(UserConverter.convertToDTO(user));

    }
    return usersDTO;
  }

  @Override
  public void add(UserDTO userDTO) {
    User user = UserConverter.convertFromDTO(userDTO);
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    this.userRepository.add(user);

  }

  @Override
  public Integer delete(UserDTO userDTO) {
    try {
      User user = this.userRepository.delete(UserConverter.convertFromDTO(userDTO));
      return user.getId();
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }
  }

  @Override
  public UserDTO login(UserDTO userDTOLoggin) {
    User userByUsername = this.userRepository.getUserByUserName(userDTOLoggin.getUsername());

    UserDTO userDTO = UserConverter.convertToDTO(userByUsername);

    if (userDTO != null) {
      if (userDTOLoggin.getPassword().equals(passwordEncoder.encode(userDTO.getPassword()))) {
        return userDTO;
      }
    }

    return null;
  }

}
