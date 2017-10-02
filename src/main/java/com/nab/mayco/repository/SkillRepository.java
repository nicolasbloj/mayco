package com.nab.mayco.repository;

import java.util.List;

import com.nab.mayco.model.Skill;

public interface SkillRepository {

  public Skill delete(Skill skill);

  public void add(Skill skill);

  public List<Skill> list();

}
