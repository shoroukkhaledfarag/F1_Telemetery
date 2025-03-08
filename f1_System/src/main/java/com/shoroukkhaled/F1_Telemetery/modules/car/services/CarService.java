package com.shoroukkhaled.F1_Telemetery.modules.car.services;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import com.shoroukkhaled.F1_Telemetery.modules.car.interfaces.ICarService;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CreateCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.SimpleCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.UpdateCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.repositories.CarRepository;
import com.shoroukkhaled.F1_Telemetery.modules.car.mappers.CarMapper;
import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;
import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService implements ICarService {
    private final CarRepository carRepository;
    private final CarMapper carMapper;

    @Override
    public SimpleCarDto create(CreateCarDto createCarDto) {
        validate(createCarDto);
        Car car = carMapper.toEntity(createCarDto);
        car.setTeam(new Team(createCarDto.getTeamId()));
        car.setDriver(new Driver(createCarDto.getDriverId()));
        car = carRepository.save(car);
        return carMapper.toSimpleCarDto(car);
    }

    private void validate(CreateCarDto createCarDto) {
        if (createCarDto.getModel() == null || createCarDto.getModel().isEmpty()) {
            throw new RuntimeException("Car Model can't be empty");
        }
    }

    @Override
    public SimpleCarDto update(UpdateCarDto updateCarDto) {
        return carRepository.findById(updateCarDto.getId())
                .map(car -> {
                    car.setModel(updateCarDto.getModel());
                    // Add other fields to update
                    Car savedCar = carRepository.save(car);
                    return carMapper.toSimpleCarDto(savedCar);
                })
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public void deleteById(Long id) {
        carRepository.findById(id)
                .map(car -> {
                    car.setIsDeleted(true);
                    Car savedCar = carRepository.save(car);
                    return carMapper.toSimpleCarDto(savedCar);
                })
                .orElseThrow(() -> new RuntimeException("Car not found"));
    }

    @Override
    public CarDto getById(Long id) {
        Car car = carRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        return carMapper.toCarDto(car);
    }

    @Override
    public List<CarDto> getAll() {
        return carRepository.findAll().stream().map(carMapper::toCarDto).toList();
    }
}
