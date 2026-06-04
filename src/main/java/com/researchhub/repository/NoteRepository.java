package com.researchhub.repository;

import com.researchhub.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    List<Note> findByProjectId(Long projectId);
    List<Note> findByCreatedBy(Long createdBy);
}
