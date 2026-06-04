package com.researchhub.controller;

import com.researchhub.model.Experiment;
import com.researchhub.model.Paper;
import com.researchhub.model.Project;
import com.researchhub.service.ExperimentService;
import com.researchhub.service.PaperService;
import com.researchhub.service.ProjectService;
import com.researchhub.service.TeamService;
import com.researchhub.service.NoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {

    private final PaperService paperService;
    private final ExperimentService experimentService;
    private final ProjectService projectService;
    private final TeamService teamService;
    private final NoteService noteService;

    public HomeController(PaperService paperService, ExperimentService experimentService,
                          ProjectService projectService, TeamService teamService, NoteService noteService) {
        this.paperService = paperService;
        this.experimentService = experimentService;
        this.projectService = projectService;
        this.teamService = teamService;
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "redirect:/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        Map<String, Long> stats = new HashMap<>();
        stats.put("paperCount", paperService.count());
        stats.put("experimentCount", experimentService.count());
        stats.put("projectCount", projectService.count());
        stats.put("teamCount", teamService.count());
        stats.put("noteCount", noteService.count());
        model.addAttribute("stats", stats);

        List<Paper> recentPapers = paperService.findAll().stream().limit(5).toList();
        List<Experiment> recentExperiments = experimentService.findAll().stream().limit(5).toList();
        model.addAttribute("recentPapers", recentPapers);
        model.addAttribute("recentExperiments", recentExperiments);

        return "dashboard/index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
