package com.shoroukkhaled.F1_Telemetery.modules.team.models;


import com.shoroukkhaled.F1_Telemetery.modules.car.models.CarDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.DriverDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
public class TeamDto {

    private Long id;
    private String name;
    private String country;
    private List<DriverDto> drivers;
    private List<CarDto> cars;

}
