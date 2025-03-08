package com.shoroukkhaled.F1_Telemetery.modules.car.controllers;

import com.shoroukkhaled.F1_Telemetery.modules.car.interfaces.ICarService;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CreateCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.SimpleCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.UpdateCarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * @RestController  this defines the class as a controller where every method returns a rest json object instead of a xml view.
 * */

@RestController
@RequestMapping("/cars")
@RequiredArgsConstructor
public class CarController {

    private final ICarService carService;

    @PostMapping
    public ResponseEntity<SimpleCarDto> createCar(@RequestBody CreateCarDto createCarDto) {
        SimpleCarDto createdCar = carService.create(createCarDto);
        if(createdCar == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(createdCar);
    }

    @PutMapping
    public ResponseEntity<SimpleCarDto> updateCar(@RequestBody UpdateCarDto updateCarDto) {
        SimpleCarDto updatedCar;
        try {
            updatedCar =  carService.update(updateCarDto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
        return ResponseEntity.ok(updatedCar);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        carService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable Long id) {
        CarDto car = carService.getById(id);
        if(car == null)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        return ResponseEntity.ok(car);
    }

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        List<CarDto> cars = carService.getAll();
        if(cars == null || cars.isEmpty())
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        return ResponseEntity.ok(cars);
    }
}
