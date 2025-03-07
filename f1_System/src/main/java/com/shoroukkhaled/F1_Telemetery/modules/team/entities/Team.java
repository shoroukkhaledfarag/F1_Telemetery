package com.shoroukkhaled.F1_Telemetery.modules.team.entities;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "teams")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @OneToMany(mappedBy = "team")
    private List<Driver> drivers;

    @OneToMany(mappedBy = "team")
    private List<Car> cars;
}
