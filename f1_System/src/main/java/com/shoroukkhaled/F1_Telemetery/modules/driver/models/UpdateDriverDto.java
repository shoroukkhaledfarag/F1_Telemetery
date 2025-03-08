package com.shoroukkhaled.F1_Telemetery.modules.driver.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@AllArgsConstructor
public class UpdateDriverDto {

    private Long id;
    private String name;
    private String country;
    private Long driverNumber;
    private Long age;
    private Long weight;
    private Long height;
    private String image;
    private String biography;
}
