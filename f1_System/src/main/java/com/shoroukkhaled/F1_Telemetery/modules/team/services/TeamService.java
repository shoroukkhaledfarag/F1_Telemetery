package com.shoroukkhaled.F1_Telemetery.modules.team.services;

import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;
import com.shoroukkhaled.F1_Telemetery.modules.team.interfaces.ITeamService;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.CreateTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.SimpleTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.TeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.UpdateTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.repositories.TeamRepository;
import com.shoroukkhaled.F1_Telemetery.modules.team.mappers.TeamMapper;
import com.shoroukkhaled.F1_Telemetery.shared.enums.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * by creating ITeamService this implemented 2nd pillar which is Abstraction, controller doesn't have to know the implementation
 * of the service, it just needs to know the interface
 *
 * */
@Service
@RequiredArgsConstructor
public class TeamService implements ITeamService {

    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    @Override
    public SimpleTeamDto create(CreateTeamDto createTeamDto) {
        validate(createTeamDto);
        Team team = teamMapper.toEntity(createTeamDto);
        team = teamRepository.save(team);
        return teamMapper.toSimpleTeamDto(team);
    }

    private void validate(CreateTeamDto createTeamDto) {
        if(createTeamDto.getName() == null || createTeamDto.getName().isEmpty())
        {
            throw new RuntimeException("Team Name can't be empty ");
        }
        if(teamRepository.existsByName(createTeamDto.getName())){
            throw new RuntimeException("Team with name " + createTeamDto.getName() + " already exists");
        }
        if(createTeamDto.getCountry() == null || createTeamDto.getCountry().isEmpty())
        {
            throw new RuntimeException("Country not found");
        }
        if(Country.valueOf(createTeamDto.getCountry().toUpperCase()) == null)
        {
            throw new RuntimeException("Country not found");
        }
    }

    @Override
    public SimpleTeamDto update(UpdateTeamDto updateTeamDto) {
        return teamRepository.findById(updateTeamDto.getId())
                .map(team -> {
                    //todo: validate
                    //todo: update more fields
                    team.setName(updateTeamDto.getName());
                    Team savedTeam = teamRepository.save(team);
                    return teamMapper.toSimpleTeamDto(savedTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Override
    public void deleteById(Long id) {
        teamRepository.findById(id)
                .map(team -> {
                    team.setIsDeleted(true);
                    Team savedTeam = teamRepository.save(team);
                    return teamMapper.toSimpleTeamDto(savedTeam);
                })
                .orElseThrow(() -> new RuntimeException("Team not found"));
    }

    @Override
    public TeamDto getById(Long id) {
        Team team = teamRepository.findById(id).orElse(null);
        return teamMapper.toTeamDto(team);
    }

    @Override
    public List<TeamDto> getAll() {
        return teamRepository.findAll().stream().map(teamMapper::toTeamDto).toList();
    }
}
