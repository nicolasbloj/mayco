package com.nab.mayco.util;

import java.util.Base64;

import org.apache.log4j.Logger;

import com.nab.mayco.dto.ProjectDTO;
import com.nab.mayco.model.Project;


// singleton
public class ProjectConverter {

  // not static
  private static Logger logger = Logger.getLogger(ProjectConverter.class);

  public static ProjectDTO convertToDTO(Project project) {
    byte[] encoded = null;
    String image = null;

    if (project.getImage() != null) {
      encoded = Base64.getEncoder().encode(project.getImage());
      logger.info("ENCODED --> " + encoded);
      image = new String(encoded);
    }
    return new ProjectDTO(project.getId(), project.getName(), image);
  }

  public static Project convertFromDTO(ProjectDTO projectDTO) {
    byte[] decoded = null;

    if (projectDTO.getImageEncoded() != null) {
      decoded = Base64.getDecoder().decode(projectDTO.getImageEncoded().getBytes());
      logger.info("DECODED --> " + decoded);
    } else {
      if (projectDTO.getId() != null)
        return new Project(projectDTO.getId(), projectDTO.getName());
    }

    return new Project(projectDTO.getName(), decoded);
  }

}
