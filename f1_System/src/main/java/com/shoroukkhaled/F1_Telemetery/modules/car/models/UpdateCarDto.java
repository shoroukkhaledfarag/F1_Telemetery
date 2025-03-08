package com.shoroukkhaled.F1_Telemetery.modules.car.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class UpdateCarDto {

    private Long id;
    private String model;
    private String engine;
}
