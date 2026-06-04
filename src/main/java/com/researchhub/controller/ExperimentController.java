package com.researchhub.controller;

import com.researchhub.dto.ExperimentDTO;
import com.researchhub.model.Experiment;
import com.researchhub.service.ExperimentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/experiments")
public class ExperimentController {

    private final ExperimentService experimentService;

    public ExperimentController(ExperimentService experimentService) {
        this.experimentService = experimentService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("experiments", experimentService.findAll());
        return "experiment/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Experiment experiment = experimentService.findById(id).orElseThrow();
        model.addAttribute("experiment", experiment);
        return "experiment/detail";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("experimentDTO", new ExperimentDTO());
        model.addAttribute("statuses", Experiment.ExperimentStatus.values());
        return "experiment/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute ExperimentDTO experimentDTO) {
        experimentService.create(experimentDTO, 1L);
        return "redirect:/experiments";
    }
}
