package com.nab.mayco.service;

import java.util.List;

import com.nab.mayco.dto.SkillDTO;

public interface SkillService {
  public Integer delete(SkillDTO skillDTO);

  public void add(SkillDTO skillDTO); // Deberiamos devolver id

  public List<SkillDTO> list();
}
