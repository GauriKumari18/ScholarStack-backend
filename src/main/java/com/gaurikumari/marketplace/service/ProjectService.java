package com.gaurikumari.marketplace.service;

import com.gaurikumari.marketplace.dto.Request.ProjectRequest;
import com.gaurikumari.marketplace.dto.Response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse createProject(ProjectRequest request);

    List<ProjectResponse> getAllProjects();

    ProjectResponse getProjectById(Long id);

}