package com.researchhub.controller;

import com.researchhub.model.Project;
import com.researchhub.service.ProjectService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("projects", projectService.findAll());
        return "project/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Project project = projectService.findById(id).orElseThrow();
        model.addAttribute("project", project);
        return "project/detail";
    }

    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("project", new Project());
        model.addAttribute("statuses", Project.ProjectStatus.values());
        return "project/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute Project project) {
        project.setCreatedBy(1L);
        projectService.create(project);
        return "redirect:/projects";
    }
}
