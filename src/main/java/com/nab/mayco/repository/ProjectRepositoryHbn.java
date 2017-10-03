package com.nab.mayco.repository;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.nab.mayco.model.Project;

@Transactional
@Repository("ProjectRepositoryHbn")
public class ProjectRepositoryHbn extends RepositoryHbn<Integer, Project>
    implements ProjectRepository {

}
