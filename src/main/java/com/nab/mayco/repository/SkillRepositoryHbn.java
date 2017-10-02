package com.nab.mayco.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.Skill;


@Transactional
@Repository("SkillRepositoryHbn")
public class SkillRepositoryHbn extends RepositoryHbn<Integer, Skill> implements SkillRepository {

}
