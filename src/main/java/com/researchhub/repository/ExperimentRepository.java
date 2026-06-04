package com.researchhub.repository;

import com.researchhub.model.Experiment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ExperimentRepository extends JpaRepository<Experiment, Long> {
    List<Experiment> findByProjectId(Long projectId);
    List<Experiment> findByCreatedBy(Long createdBy);
    List<Experiment> findByStatus(Experiment.ExperimentStatus status);
}
