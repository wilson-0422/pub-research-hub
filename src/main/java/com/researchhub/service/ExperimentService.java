package com.researchhub.service;

import com.researchhub.dto.ExperimentDTO;
import com.researchhub.model.Experiment;
import com.researchhub.repository.ExperimentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ExperimentService {

    private final ExperimentRepository experimentRepository;

    public ExperimentService(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }

    public List<Experiment> findAll() {
        return experimentRepository.findAll();
    }

    public Optional<Experiment> findById(Long id) {
        return experimentRepository.findById(id);
    }

    public List<Experiment> findByProjectId(Long projectId) {
        return experimentRepository.findByProjectId(projectId);
    }

    public List<Experiment> findByCreatedBy(Long createdBy) {
        return experimentRepository.findByCreatedBy(createdBy);
    }

    @Transactional
    public Experiment create(ExperimentDTO dto, Long createdBy) {
        Experiment experiment = new Experiment();
        experiment.setTitle(dto.getTitle());
        experiment.setDescription(dto.getDescription());
        experiment.setHypothesis(dto.getHypothesis());
        experiment.setMethodology(dto.getMethodology());
        experiment.setResults(dto.getResults());
        experiment.setConclusion(dto.getConclusion());
        experiment.setStatus(Experiment.ExperimentStatus.valueOf(dto.getStatus()));
        experiment.setProjectId(dto.getProjectId());
        experiment.setCreatedBy(createdBy);
        return experimentRepository.save(experiment);
    }

    @Transactional
    public Experiment update(Long id, ExperimentDTO dto) {
        Experiment experiment = experimentRepository.findById(id).orElseThrow();
        experiment.setTitle(dto.getTitle());
        experiment.setDescription(dto.getDescription());
        experiment.setHypothesis(dto.getHypothesis());
        experiment.setMethodology(dto.getMethodology());
        experiment.setResults(dto.getResults());
        experiment.setConclusion(dto.getConclusion());
        experiment.setStatus(Experiment.ExperimentStatus.valueOf(dto.getStatus()));
        experiment.setProjectId(dto.getProjectId());
        experiment.setUpdatedAt(LocalDateTime.now());
        return experimentRepository.save(experiment);
    }

    @Transactional
    public void delete(Long id) {
        experimentRepository.deleteById(id);
    }

    public long count() {
        return experimentRepository.count();
    }
}
