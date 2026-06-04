package com.researchhub.service;

import com.researchhub.model.Project;
import com.researchhub.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Optional<Project> findById(Long id) {
        return projectRepository.findById(id);
    }

    public List<Project> findByTeamId(Long teamId) {
        return projectRepository.findByTeamId(teamId);
    }

    public List<Project> findByCreatedBy(Long createdBy) {
        return projectRepository.findByCreatedBy(createdBy);
    }

    @Transactional
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    @Transactional
    public Project update(Long id, Project updated) {
        Project project = projectRepository.findById(id).orElseThrow();
        project.setName(updated.getName());
        project.setDescription(updated.getDescription());
        project.setTeamId(updated.getTeamId());
        project.setStatus(updated.getStatus());
        project.setStartDate(updated.getStartDate());
        project.setEndDate(updated.getEndDate());
        return projectRepository.save(project);
    }

    @Transactional
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }

    public long count() {
        return projectRepository.count();
    }
}
