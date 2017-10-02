package com.nab.mayco.util;

import com.nab.mayco.dto.SkillDTO;
import com.nab.mayco.model.Skill;

public class SkillConverter {


  public static SkillDTO convertToDTO(Skill skill) {
    return new SkillDTO(skill.getId(), skill.getName(), skill.getDescription());
  }

  public static Skill convertFromDTO(SkillDTO skillDTO) {
    if (skillDTO.getId() != null)
      return new Skill(skillDTO.getId(), skillDTO.getName(), skillDTO.getDescription());
    return new Skill(skillDTO.getName(), skillDTO.getDescription());
  }

}
