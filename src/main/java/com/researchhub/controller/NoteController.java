package com.researchhub.controller;

import com.researchhub.model.Note;
import com.researchhub.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("notes", noteService.findAll());
        return "note/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("note", new Note());
        return "note/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Note note) {
        note.setCreatedBy(1L);
        noteService.create(note);
        return "redirect:/notes";
    }
}
