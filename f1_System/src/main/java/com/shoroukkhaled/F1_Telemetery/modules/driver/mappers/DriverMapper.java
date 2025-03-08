package com.shoroukkhaled.F1_Telemetery.modules.driver.mappers;

import com.shoroukkhaled.F1_Telemetery.modules.driver.entities.Driver;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.CreateDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.DriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.SimpleDriverDto;
import com.shoroukkhaled.F1_Telemetery.shared.enums.Country;
import org.mapstruct.*;

import java.util.List;


@Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR, componentModel = "spring")
public interface DriverMapper {


    @Mappings({
            @Mapping(source = "country", target = "country", qualifiedByName = "mapStringToCountry"),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "creationTime", ignore = true),
            @Mapping(target = "lastUpdatedBy", ignore = true),
            @Mapping(target = "lastUpdatedTime", ignore = true),
            @Mapping(target = "team", ignore = true),
            @Mapping(target = "car", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "isRetired", ignore = true)

    })
    Driver toEntity(DriverDto driverDto);

    @Mappings({
            @Mapping(target = "id", ignore = true),
            @Mapping(source = "country", target = "country", qualifiedByName = "mapStringToCountry"),
            @Mapping(target = "createdBy", ignore = true),
            @Mapping(target = "creationTime", ignore = true),
            @Mapping(target = "lastUpdatedBy", ignore = true),
            @Mapping(target = "lastUpdatedTime", ignore = true),
            @Mapping(target = "team", ignore = true),
            @Mapping(target = "car", ignore = true),
            @Mapping(target = "isDeleted", ignore = true),
            @Mapping(target = "isRetired", ignore = true)
    })
    Driver toEntity(CreateDriverDto driverDto);

    List<Driver> toEntityList(List<DriverDto> driverDtos);


    @Named("mapCountryToString")
    default String mapCountryToString(Country country) {
        return (country != null) ? country.name() : null;
    }

    @Named("mapStringToCountry")
    default Country mapStringToCountry(String country) {
        return (country != null) ? Country.valueOf(country) : null;
    }

    SimpleDriverDto toSimpleDriverDto(Driver driver);

    @Mappings({
            @Mapping(source = "country", target = "country", qualifiedByName = "mapCountryToString")
    })
    DriverDto toDriverDto(Driver driver);
}