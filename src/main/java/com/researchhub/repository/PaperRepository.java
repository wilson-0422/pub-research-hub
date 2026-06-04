package com.researchhub.repository;

import com.researchhub.model.Paper;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PaperRepository extends JpaRepository<Paper, Long> {
    List<Paper> findByProjectId(Long projectId);
    List<Paper> findByCreatedBy(Long createdBy);
    List<Paper> findByStatus(Paper.PaperStatus status);
    List<Paper> findByTitleContainingIgnoreCase(String keyword);
}
