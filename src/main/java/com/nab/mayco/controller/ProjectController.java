package com.nab.mayco.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nab.mayco.dto.ProjectDTO;
import com.nab.mayco.service.ProjectService;

@RestController
@RequestMapping("/project")
@CrossOrigin
public class ProjectController {

  @Autowired
  @Qualifier("ProjectService")
  ProjectService service;

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<ProjectDTO>> list() {
    List<ProjectDTO> projects = service.list();
    return new ResponseEntity<List<ProjectDTO>>(projects, HttpStatus.OK);
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> add(
      @RequestBody ProjectDTO projectDTO/* , UriComponentsBuilder builder */) {
    service.add(projectDTO); // control flag si existe ya, HttpStatus.CONFLICT
    // headers.setLocation(builder.path("/project/{id}").buildAndExpand(article.getProjectId()).toUri());
    return new ResponseEntity<String>("Proyecto cargado correctamente", HttpStatus.CREATED);
  }

  // recibimos solo id, TODAVIA NO PROBADO
  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
      consumes = "application/json", produces = "application/json")
  public ResponseEntity<Map<String, Integer>> delete(
      @RequestBody(required = true) @PathVariable("id") int projectId) {

    HttpStatus httpStatus = HttpStatus.OK;
    String msg = "El proyecto eliminado correctamente.";
    Map<String, Integer> map = new HashMap<String, Integer>();
    Integer id = -1;

    try {
      ProjectDTO projectDTO = new ProjectDTO(projectId);
      id = service.delete(projectDTO);

      if (id == -1) {
        msg = (new StringBuilder(50).append("No se pudo eliminar el proyecto ")
            .append(projectDTO.getId()).toString());
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      }

    } catch (Exception e) {
      msg = "El proyecto no fue eliminado.";
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    map.put(msg, id);
    return new ResponseEntity<>(map, httpStatus);

  }

}
