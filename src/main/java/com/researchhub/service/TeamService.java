package com.researchhub.service;

import com.researchhub.model.Team;
import com.researchhub.repository.TeamRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    public List<Team> findByLeaderId(Long leaderId) {
        return teamRepository.findByLeaderId(leaderId);
    }

    @Transactional
    public Team create(Team team) {
        return teamRepository.save(team);
    }

    @Transactional
    public Team update(Long id, Team updated) {
        Team team = teamRepository.findById(id).orElseThrow();
        team.setName(updated.getName());
        team.setDescription(updated.getDescription());
        team.setLeaderId(updated.getLeaderId());
        team.setField(updated.getField());
        return teamRepository.save(team);
    }

    @Transactional
    public void delete(Long id) {
        teamRepository.deleteById(id);
    }

    public long count() {
        return teamRepository.count();
    }
}
