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

import com.nab.mayco.dto.SkillDTO;
import com.nab.mayco.service.SkillService;

@RestController
@RequestMapping("/skill")
@CrossOrigin
public class SkillController {

  @Autowired
  @Qualifier("SkillService")
  SkillService service;

  @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
  @ResponseStatus(value = HttpStatus.OK)
  public ResponseEntity<List<SkillDTO>> list() {
    List<SkillDTO> skills = service.list();
    return new ResponseEntity<List<SkillDTO>>(skills, HttpStatus.OK);
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json",
      produces = "application/json")
  public ResponseEntity<String> add(@RequestBody SkillDTO skillDTO) {
    service.add(skillDTO); // control flag si existe ya, HttpStatus.CONFLICT
    return new ResponseEntity<String>("Servicio cargado correctamente", HttpStatus.CREATED);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
      consumes = "application/json", produces = "application/json")
  public ResponseEntity<Map<String, Integer>> delete(
      @RequestBody(required = true) @PathVariable("id") int skillId) {

    HttpStatus httpStatus = HttpStatus.OK;
    String msg = "El servicio fue eliminado correctamente.";
    Map<String, Integer> map = new HashMap<String, Integer>();
    Integer id = -1;

    try {
      SkillDTO skillDTO = new SkillDTO(skillId);
      id = service.delete(skillDTO);

      if (id == -1) {
        msg = (new StringBuilder(50).append("No se pudo eliminar el servicio ")
            .append(skillDTO.getId()).toString());
        httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
      }

    } catch (Exception e) {
      msg = "El servicio no fue eliminado.";
      httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    map.put(msg, id);
    return new ResponseEntity<>(map, httpStatus);

  }


}
