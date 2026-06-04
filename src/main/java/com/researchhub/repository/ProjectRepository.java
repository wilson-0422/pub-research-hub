package com.researchhub.repository;

import com.researchhub.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findByTeamId(Long teamId);
    List<Project> findByCreatedBy(Long createdBy);
    List<Project> findByStatus(Project.ProjectStatus status);
}
