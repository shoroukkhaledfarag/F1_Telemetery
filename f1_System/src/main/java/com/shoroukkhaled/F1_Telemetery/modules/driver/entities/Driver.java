package com.shoroukkhaled.F1_Telemetery.modules.driver.entities;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;

import javax.persistence.*;

@Entity
@Table(name = "drivers")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(mappedBy = "driver")
    private Car car;
}

