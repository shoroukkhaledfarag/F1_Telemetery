package com.shoroukkhaled.F1_Telemetery.modules.team.mappers;

import com.shoroukkhaled.F1_Telemetery.modules.car.mappers.CarMapper;
import com.shoroukkhaled.F1_Telemetery.modules.driver.mappers.DriverMapper;
import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.CreateTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.SimpleTeamDto;
import com.shoroukkhaled.F1_Telemetery.modules.team.models.TeamDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.ERROR, uses = {DriverMapper.class, CarMapper.class})
public interface TeamMapper {

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "creationTime", ignore = true),
            @Mapping(target = "lastUpdatedBy", ignore = true),
            @Mapping(target = "lastUpdatedTime", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "country", source = "createTeamDto.country"),
            @Mapping(target = "name", source = "createTeamDto.name"),
            @Mapping(target = "drivers", ignore = true),
            @Mapping(target = "cars", ignore = true),
    })
    Team toEntity(CreateTeamDto createTeamDto);

    TeamDto toTeamDto(Team team);

    SimpleTeamDto toSimpleTeamDto(Team team);

}