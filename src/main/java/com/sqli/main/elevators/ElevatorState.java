package com.sqli.main.elevators;

public interface ElevatorState{

    public void up(Building building , Elevator elevator , int destination);
    public void down(Building building , Elevator elevator , int destination);
    public void stop(Building building , Elevator elevator , int destination) ;

}
