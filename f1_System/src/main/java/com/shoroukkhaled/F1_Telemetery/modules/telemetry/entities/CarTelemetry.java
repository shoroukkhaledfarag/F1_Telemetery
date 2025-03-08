package com.shoroukkhaled.F1_Telemetery.modules.telemetry.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "car_telemetry")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarTelemetry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "timestamp")
    private long timestamp;

    @Column(name = "speed")
    private double speed;

    @Column(name = "rpm")
    private int rpm;

    @Column(name = "tire_pressure")
    private double tirePressure;

    @Column(name = "fuel_level")
    private double fuelLevel;

    @Column(name = "engine_temp")
    private double engineTemp;

    @Column(name = "battery_voltage")
    private double batteryVoltage;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

}
