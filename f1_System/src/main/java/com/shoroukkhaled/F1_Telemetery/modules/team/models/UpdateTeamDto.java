package com.shoroukkhaled.F1_Telemetery.modules.team.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UpdateTeamDto {
    private Long id;
    private String name;
}
