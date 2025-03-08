package com.shoroukkhaled.F1_Telemetery.modules.car.mappers;

import com.shoroukkhaled.F1_Telemetery.modules.car.entities.Car;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CreateCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.SimpleCarDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface CarMapper {

    @Mappings({
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "creationTime", ignore = true),
            @Mapping(target = "lastUpdatedBy", ignore = true),
            @Mapping(target = "lastUpdatedTime", ignore = true),
            @Mapping(target = "team", ignore = true),
            @Mapping(target = "driver", ignore = true),
            @Mapping(target = "isDeleted", ignore = true)
    })
    Car toEntity(CarDto carDto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "creationTime", ignore = true),
            @Mapping(target = "lastUpdatedBy", ignore = true),
            @Mapping(target = "lastUpdatedTime", ignore = true),
            @Mapping(target = "team", ignore = true),
            @Mapping(target = "driver", ignore = true),
            @Mapping(target = "isDeleted", ignore = true)
    })
    Car toEntity(CreateCarDto carDto);

    List<Car> toEntityList(List<CarDto> carDtos);

    SimpleCarDto toSimpleCarDto(Car car);

    @Mappings({
            @Mapping(target ="id",source = "id"),
            @Mapping(target = "model", source = "model"),
            @Mapping(target = "engine", source = "engine")
    })
    CarDto toCarDto(Car car);

}