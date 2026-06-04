package com.researchhub.service;

import com.researchhub.model.Note;
import com.researchhub.repository.NoteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> findAll() {
        return noteRepository.findAll();
    }

    public Optional<Note> findById(Long id) {
        return noteRepository.findById(id);
    }

    public List<Note> findByProjectId(Long projectId) {
        return noteRepository.findByProjectId(projectId);
    }

    public List<Note> findByCreatedBy(Long createdBy) {
        return noteRepository.findByCreatedBy(createdBy);
    }

    @Transactional
    public Note create(Note note) {
        return noteRepository.save(note);
    }

    @Transactional
    public Note update(Long id, Note updated) {
        Note note = noteRepository.findById(id).orElseThrow();
        note.setTitle(updated.getTitle());
        note.setContent(updated.getContent());
        note.setProjectId(updated.getProjectId());
        note.setUpdatedAt(LocalDateTime.now());
        return noteRepository.save(note);
    }

    @Transactional
    public void delete(Long id) {
        noteRepository.deleteById(id);
    }

    public long count() {
        return noteRepository.count();
    }
}
