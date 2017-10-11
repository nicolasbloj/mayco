package com.nab.mayco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.mayco.dto.UserDTO;
import com.nab.mayco.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {

  // private Logger logger = Logger.getAnonymousLogger();

  @Autowired
  UserService service;

  @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<Map<String, UserDTO>> login(@RequestBody UserDTO userDTOLogging) {

    UserDTO userDTO = service.login(userDTOLogging);

    Map<String, UserDTO> map = new HashMap<String, UserDTO>();
    HttpStatus httpStatus = HttpStatus.OK;
    String msg = "Usuario logeado correctamente";

    if (userDTO == null) {
      httpStatus = HttpStatus.OK;
      msg = "Usuario o contraseña incorrecto";
    }

    map.put(msg, userDTO);

    return new ResponseEntity<>(map, httpStatus);
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<Map<String, Integer>> add(@RequestBody UserDTO userDTO) {
    Map<String, Integer> map = new HashMap<String, Integer>();
    Integer id = service.add(userDTO);
    map.put("Usuario cargado correctamente...", id);
    return new ResponseEntity<>(map, HttpStatus.CREATED);
  }

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<UserDTO>> list() {
    List<UserDTO> users = service.list();
    return new ResponseEntity<List<UserDTO>>(users, HttpStatus.OK); // MEJORAR ESTAS SALIDAS
  }


  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
      consumes = "application/json", produces = "application/json")
  public ResponseEntity<Map<String, Integer>> delete(
      @RequestBody(required = true) @PathVariable("id") int userId) {

    HttpStatus httpStatus = HttpStatus.OK;
    String msg = "El usuario fue eliminado correctamente.";
    Map<String, Integer> map = new HashMap<String, Integer>();
    Integer id = -1;

    try {
      UserDTO userDTO = new UserDTO(userId);
      id = service.delete(userDTO);

      if (id == -1) {
        msg = (new StringBuilder(50).append("No se pudo eliminar el usuario ")
            .append(userDTO.getId()).toString());
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      }

    } catch (Exception e) {
      msg = "El usuario no fue eliminado.";
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    map.put(msg, id);
    return new ResponseEntity<>(map, httpStatus);

  }



  @RequestMapping(value = "/adduseradmin", method = RequestMethod.GET,
      produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public String adduseradmin() {
    Integer id = service.add(new UserDTO("admin", "admin", "admin@123456"));
    if (id > 0) {
      return "added";
    }
    return "added fail";

  }

}
