package com.nab.mayco.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nab.mayco.dto.SkillDTO;
import com.nab.mayco.model.Skill;
import com.nab.mayco.repository.SkillRepository;
import com.nab.mayco.util.SkillConverter;

@Service("SkillService")
public class SkillServiceImpl implements SkillService {

  @Autowired
  @Qualifier("SkillRepositoryHbn")
  private SkillRepository skillReposityory;

  @Override
  public List<SkillDTO> list() {
    List<SkillDTO> skillsDTO = new ArrayList<SkillDTO>();

    for (Skill skill : skillReposityory.list()) {
      skillsDTO.add(SkillConverter.convertToDTO(skill));

    }
    return skillsDTO;
  }

  @Override
  public void add(SkillDTO skillDTO) {
    this.skillReposityory.add(SkillConverter.convertFromDTO(skillDTO));
  }


  @Override
  public Integer delete(SkillDTO skillDTO) {
    try {
      Skill skill = this.skillReposityory.delete(SkillConverter.convertFromDTO(skillDTO));
      return skill.getId();
    } catch (Exception e) {
      e.printStackTrace();
      return -1;
    }


  }


}
