package com.shoroukkhaled.F1_Telemetery.modules.team.interfaces;


import com.shoroukkhaled.F1_Telemetery.interfaces.ICrudService;

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
public interface ITeamService extends ICrudService {
}
