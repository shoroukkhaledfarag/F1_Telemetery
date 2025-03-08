package com.shoroukkhaled.F1_Telemetery.modules.team.controllers;

import com.shoroukkhaled.F1_Telemetery.modules.team.interfaces.ITeamService;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.CreateTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.SimpleTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.TeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.UpdateTeamDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/team")
@RestController
public class TeamController {

    private final ITeamService teamService;

    public TeamController(ITeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping()
    private ResponseEntity<SimpleTeamDto> createTeam(@RequestBody CreateTeamDto createTeamDto) {
        SimpleTeamDto team = teamService.create(createTeamDto);
        if(team == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(team);
    }

    @PutMapping()
    private ResponseEntity<SimpleTeamDto> updateTeam(@RequestBody UpdateTeamDto updateTeamDto) {
        SimpleTeamDto updatedTeam;
        try {
            updatedTeam = teamService.update(updateTeamDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(updatedTeam);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteTeam(@PathVariable("id") Long id) {
        teamService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    private ResponseEntity<TeamDto> getTeamById(@PathVariable("id") Long id) {
        TeamDto team = teamService.getById(id);
        if(team == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        return ResponseEntity.ok(team);
    }

    @GetMapping("/all")
    private ResponseEntity<List<TeamDto>> getAllTeams() {
        List<TeamDto> teams = teamService.getAll();
        if(teams == null || teams.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        return ResponseEntity.ok(teams);
    }


}
