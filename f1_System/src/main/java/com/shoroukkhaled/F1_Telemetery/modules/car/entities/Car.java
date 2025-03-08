package com.shoroukkhaled.F1_Telemetery.modules.car.entities;

import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;
import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;
import com.shoroukkhaled.F1_Telemetery.shared.entities.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * all annotations belong to Jakarta Persistence API (JPA), which is used in Spring Data JPA.
 * this class accomplished Encapsulation of the Car entity. which is the first pillar of OOP.
 * */
@Getter
@Setter
@Entity
@Table(name = "cars")
public class Car extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "model")
    private String model;

    @Column(name = "engine")
    private String engine;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
