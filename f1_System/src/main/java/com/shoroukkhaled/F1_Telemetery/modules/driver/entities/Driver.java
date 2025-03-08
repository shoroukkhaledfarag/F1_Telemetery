package com.shoroukkhaled.F1_Telemetery.modules.driver.entities;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;
import com.shoroukkhaled.F1_Telemetery.shared.entities.BaseEntity;
import com.shoroukkhaled.F1_Telemetery.shared.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "drivers")
public class Driver extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "driver_number")
    private Long driverNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @Column(name = "age")
    private Long age;

    @Column(name = "weight")
    private Long weight;

    @Column(name = "height")
    private Long height;

    @Column(name = "image")
    private String image;

    @Column(name = "biography")
    private String biography;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "is_retired")
    private Boolean isRetired;

    //many Drivers can be associated with one instance of Team
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    //one Driver can be associated with one instance of Car
    @OneToOne(mappedBy = "driver")
    private Car car;

    public Driver(Long driverId) {
        this.id = driverId;
    }
}

