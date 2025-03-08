package com.shoroukkhaled.F1_Telemetery.modules.team.entities;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;
import com.shoroukkhaled.F1_Telemetery.shared.entities.BaseEntity;
import com.shoroukkhaled.F1_Telemetery.shared.enums.Country;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "teams")
public class Team extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "country")
    private Country country;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "team")
    private List<Driver> drivers;

    @OneToMany(mappedBy = "team")
    private List<Car> cars;

    public Team(Long teamId) {
        this.id = teamId;
    }
}
