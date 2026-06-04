package com.researchhub.controller;

import com.researchhub.model.Team;
import com.researchhub.service.TeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/teams")
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("teams", teamService.findAll());
        return "team/list";
    }

    @GetMapping("/{id}")
    public String detail(@PathVariable Long id, Model model) {
        Team team = teamService.findById(id).orElseThrow();
        model.addAttribute("team", team);
        return "team/detail";
    }
}
