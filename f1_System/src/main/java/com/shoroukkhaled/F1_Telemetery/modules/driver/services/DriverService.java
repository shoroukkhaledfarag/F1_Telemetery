package com.shoroukkhaled.F1_Telemetery.modules.driver.services;

import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;
import com.shoroukkhaled.F1_Telemetery.modules.driver.interfaces.IDriverService;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.CreateDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.SimpleDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.DriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.UpdateDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.repositories.DriverRepository;
import com.shoroukkhaled.F1_Telemetery.modules.driver.mappers.DriverMapper;
import com.shoroukkhaled.F1_Telemetery.modules.team.entities.Team;
import com.shoroukkhaled.F1_Telemetery.shared.enums.Country;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService implements IDriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    @Override
    public SimpleDriverDto create(CreateDriverDto createDriverDto) {
        validate(createDriverDto);
        Driver driver = driverMapper.toEntity(createDriverDto);
        driver.setTeam(new Team(createDriverDto.getTeamId()));
        driver = driverRepository.save(driver);
        return driverMapper.toSimpleDriverDto(driver);
    }

    private void validate(CreateDriverDto createDriverDto) {
        if (createDriverDto.getName() == null || createDriverDto.getName().isEmpty()) {
            throw new RuntimeException("Driver Name can't be empty");
        }
        if (createDriverDto.getDriverNumber() == null) {
            throw new RuntimeException("Driver Number is required");
        }
        if (createDriverDto.getCountry() == null || createDriverDto.getCountry().isEmpty()) {
            throw new RuntimeException("Country not found");
        }
    }

    @Override
    public SimpleDriverDto update(UpdateDriverDto updateDriverDto) {
        return driverRepository.findById(updateDriverDto.getId())
                .map(driver -> {
                    driver.setName(updateDriverDto.getName());
                    driver.setDriverNumber(updateDriverDto.getDriverNumber());
                    driver.setCountry(Country.valueOf(updateDriverDto.getCountry().toUpperCase()));
                    driver.setAge(updateDriverDto.getAge());
                    driver.setWeight(updateDriverDto.getWeight());
                    driver.setHeight(updateDriverDto.getHeight());
                    driver.setBiography(updateDriverDto.getBiography());
                    Driver savedDriver = driverRepository.save(driver);
                    return driverMapper.toSimpleDriverDto(savedDriver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public void deleteById(Long id) {
        driverRepository.findById(id)
                .map(driver -> {
                    driver.setIsDeleted(true);
                    Driver savedDriver = driverRepository.save(driver);
                    return driverMapper.toSimpleDriverDto(savedDriver);
                })
                .orElseThrow(() -> new RuntimeException("Driver not found"));
    }

    @Override
    public DriverDto getById(Long id) {
        Driver driver = driverRepository.findById(id).orElse(null);
        return driverMapper.toDriverDto(driver);
    }

    @Override
    public List<DriverDto> getAll() {
        return driverRepository.findAll().stream().map(driverMapper::toDriverDto).toList();
    }
}