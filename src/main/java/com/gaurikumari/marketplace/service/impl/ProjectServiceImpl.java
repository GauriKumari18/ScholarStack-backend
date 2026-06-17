package com.gaurikumari.marketplace.service.impl;

import com.gaurikumari.marketplace.dto.Request.ProjectRequest;
import com.gaurikumari.marketplace.dto.Response.ProjectResponse;
import com.gaurikumari.marketplace.enums.ProjectStatus;
import lombok.RequiredArgsConstructor;
import com.gaurikumari.marketplace.model.Project;
import com.gaurikumari.marketplace.model.User;
import org.springframework.stereotype.Service;
import com.gaurikumari.marketplace.repository.ProjectRepository;
import com.gaurikumari.marketplace.repository.UserRepository;
import com.gaurikumari.marketplace.service.ProjectService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {

        // 1. Find Client by clientId
        User client = userRepository.findById(request.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found with id: " + request.getClientId()));

        // 2. Create Project from Request
        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setBudget(request.getBudget());
        project.setTechStack(request.getTechStack());
        project.setExpectedDuration(request.getExpectedDuration());
        project.setComplexity(request.getComplexity());
        project.setClient(client);

        // 3. Always set status to OPEN on creation
        project.setStatus(ProjectStatus.OPEN);

        // 4. Save Project
        Project savedProject = projectRepository.save(project);

        // 5. Return Response DTO
        return mapToResponse(savedProject);
    }

    @Override
    public List<ProjectResponse> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResponse getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found with id: " + id));
        return mapToResponse(project);
    }

    private ProjectResponse mapToResponse(Project project) {
        ProjectResponse response = new ProjectResponse();
        response.setId(project.getId());
        response.setTitle(project.getTitle());
        response.setDescription(project.getDescription());
        response.setBudget(project.getBudget());
        response.setTechStack(project.getTechStack());
        response.setExpectedDuration(project.getExpectedDuration());
        response.setComplexity(project.getComplexity());
        response.setStatus(String.valueOf(project.getStatus()));
        response.setClientId(project.getClient().getId());
        response.setClientName(project.getClient().getFullName());
        response.setCreatedAt(project.getCreatedAt());
        return response;
    }

}