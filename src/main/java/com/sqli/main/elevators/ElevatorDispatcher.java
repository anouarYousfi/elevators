package com.sqli.main.elevators;

import java.util.Comparator;
import java.util.List;

public class ElevatorDispatcher {

    public Elevator findClosestElevator(List<Elevator> elevators, int requestFloor ) {

     return elevators.stream().min(Comparator.comparing(e -> Math.abs(requestFloor -e.getCurrentFloor()))).get();


    }
}
