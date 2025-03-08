package com.shoroukkhaled.F1_Telemetery.modules.driver.interfaces;


import com.shoroukkhaled.F1_Telemetery.modules.driver.models.CreateDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.DriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.SimpleDriverDto;
import com.shoroukkhaled.F1_Telemetery.modules.driver.models.UpdateDriverDto;
import com.shoroukkhaled.F1_Telemetery.shared.interfaces.ICrudService;

import java.util.List;

/**
 * ICrudService is the interface that will be implemented by all the services
 *
 * this accomplished interface segregation principle
 *
 * The Interface Segregation Principle (ISP) states that a client should not be forced to depend on methods it does not use.
 * Instead of having large, monolithic interfaces,
 * it's better to have smaller, specific interfaces tailored to the needs of different clients.
 *
 *
 * all clients need ICrudService , and if any of them need something extra , each one will have its own interface
 * now I didn't have to add the extra methods to ICrudService
 *
 * */
public interface IDriverService extends ICrudService<CreateDriverDto, UpdateDriverDto, SimpleDriverDto, DriverDto> {
}

