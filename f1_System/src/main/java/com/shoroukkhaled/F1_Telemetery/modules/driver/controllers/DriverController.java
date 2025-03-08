package com.shoroukkhaled.F1_Telemetery.modules.driver.controllers;


import com.shoroukkhaled.F1_Telemetery.modules.driver.interfaces.IDriverService;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.CreateDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.SimpleDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.DriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.UpdateDriverDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drivers")
@RequiredArgsConstructor
public class DriverController {

    private final IDriverService driverService;

    @PostMapping
    public ResponseEntity<SimpleDriverDto> createDriver(@RequestBody CreateDriverDto createDriverDto) {
        SimpleDriverDto createdDriver = driverService.create(createDriverDto);
        return ResponseEntity.ok(createdDriver);
    }

    @PutMapping
    public ResponseEntity<SimpleDriverDto> updateDriver(@RequestBody UpdateDriverDto updateDriverDto) {
        SimpleDriverDto updatedDriver = driverService.update(updateDriverDto);
        return ResponseEntity.ok(updatedDriver);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDriver(@PathVariable Long id) {
        driverService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DriverDto> getDriverById(@PathVariable Long id) {
        DriverDto driver = driverService.getById(id);
        return ResponseEntity.ok(driver);
    }

    @GetMapping
    public ResponseEntity<List<DriverDto>> getAllDrivers() {
        List<DriverDto> drivers = driverService.getAll();
        return ResponseEntity.ok(drivers);
    }
}