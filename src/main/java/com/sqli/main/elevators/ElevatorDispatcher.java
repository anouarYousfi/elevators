package com.sqli.main.elevators;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ElevatorDispatcher {

    public Elevator findClosestElevator(List<Elevator> elevators, int requestFloor ) {
        List<Elevator> goingUpElevators = elevators.stream().filter(e->e.getState().getClass()!=GoingDownState.class).collect(Collectors.toList());
     return goingUpElevators.stream().min(Comparator.comparing(e -> Math.abs(requestFloor -e.getCurrentFloor()))).get();


    }
}
