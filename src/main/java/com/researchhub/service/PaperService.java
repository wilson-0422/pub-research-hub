package com.researchhub.service;

import com.researchhub.dto.PaperDTO;
import com.researchhub.model.Paper;
import com.researchhub.repository.PaperRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PaperService {

    private final PaperRepository paperRepository;

    public PaperService(PaperRepository paperRepository) {
        this.paperRepository = paperRepository;
    }

    public List<Paper> findAll() {
        return paperRepository.findAll();
    }

    public Optional<Paper> findById(Long id) {
        return paperRepository.findById(id);
    }

    public List<Paper> findByProjectId(Long projectId) {
        return paperRepository.findByProjectId(projectId);
    }

    public List<Paper> findByCreatedBy(Long createdBy) {
        return paperRepository.findByCreatedBy(createdBy);
    }

    public List<Paper> searchByTitle(String keyword) {
        return paperRepository.findByTitleContainingIgnoreCase(keyword);
    }

    @Transactional
    public Paper create(PaperDTO dto, Long createdBy) {
        Paper paper = new Paper();
        paper.setTitle(dto.getTitle());
        paper.setAbstractText(dto.getAbstractText());
        paper.setAuthors(dto.getAuthors());
        paper.setKeywords(dto.getKeywords());
        paper.setJournal(dto.getJournal());
        paper.setPublishDate(dto.getPublishDate());
        paper.setDoi(dto.getDoi());
        paper.setStatus(Paper.PaperStatus.valueOf(dto.getStatus()));
        paper.setProjectId(dto.getProjectId());
        paper.setCreatedBy(createdBy);
        return paperRepository.save(paper);
    }

    @Transactional
    public Paper update(Long id, PaperDTO dto) {
        Paper paper = paperRepository.findById(id).orElseThrow();
        paper.setTitle(dto.getTitle());
        paper.setAbstractText(dto.getAbstractText());
        paper.setAuthors(dto.getAuthors());
        paper.setKeywords(dto.getKeywords());
        paper.setJournal(dto.getJournal());
        paper.setPublishDate(dto.getPublishDate());
        paper.setDoi(dto.getDoi());
        paper.setStatus(Paper.PaperStatus.valueOf(dto.getStatus()));
        paper.setProjectId(dto.getProjectId());
        paper.setUpdatedAt(LocalDateTime.now());
        return paperRepository.save(paper);
    }

    @Transactional
    public void delete(Long id) {
        paperRepository.deleteById(id);
    }

    public long count() {
        return paperRepository.count();
    }
}
