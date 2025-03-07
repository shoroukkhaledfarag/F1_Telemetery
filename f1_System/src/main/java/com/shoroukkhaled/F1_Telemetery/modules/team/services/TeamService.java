package com.shoroukkhaled.F1_Telemetery.modules.team.services;

import com.shoroukkhaled.F1_Telemetery.modules.team.interfaces.ITeamService;
import org.springframework.stereotype.Service;


/**
 * by creating ITeamService this implemented 2nd pillar which is Abstraction, controller doesn't have to know the implementation
 * of the service, it just needs to know the interface
 *
 * */
@Service
public class TeamService implements ITeamService {

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void get() {

    }

    @Override
    public void getAll() {

    }
}
