package com.researchhub.controller;

import com.researchhub.dto.PaperDTO;
import com.researchhub.model.Paper;
import com.researchhub.service.PaperService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/papers")
public class PaperController {

    private final PaperService paperService;

    public PaperController(PaperService paperService) {
        this.paperService = paperService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("papers", paperService.findAll());
        return "paper/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Paper paper = paperService.findById(id).orElseThrow();
        model.addAttribute("paper", paper);
        return "paper/detail";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("paperDTO", new PaperDTO());
        model.addAttribute("statuses", Paper.PaperStatus.values());
        return "paper/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute PaperDTO paperDTO) {
        paperService.create(paperDTO, 1L);
        return "redirect:/papers";
    }
}
