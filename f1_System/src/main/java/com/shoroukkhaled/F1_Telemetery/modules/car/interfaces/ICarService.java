package com.shoroukkhaled.F1_Telemetery.modules.car.interfaces;


import com.shoroukkhaled.F1_Telemetery.modules.car.models.CarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.CreateCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.SimpleCarDto;
import com.shoroukkhaled.F1_Telemetery.modules.car.models.UpdateCarDto;
import com.shoroukkhaled.F1_Telemetery.shared.interfaces.ICrudService;


public interface ICarService extends ICrudService<CreateCarDto, UpdateCarDto, SimpleCarDto, CarDto> {
}
