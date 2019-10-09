package com.sqli.main.elevators;


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Building {
    private static final Logger LOG = Logger.getLogger(String.valueOf(Building.class));
    private static String down = "DOWN";

 private  ElevatorDispatcher elevatorDispatcher;
    private int numberOfFloors;
    private List<Elevator> elevators;

    public Building(ElevatorDispatcher elevatorDispatcher, int numberOfFloors, String... elevatorsInfo) {
        this.elevatorDispatcher = elevatorDispatcher;
        this.numberOfFloors = numberOfFloors;
        elevators = new ArrayList<>();
        for (int i = 0; i < elevatorsInfo.length; i++) {
            String[] elevatorSpecifications;
            elevatorSpecifications = elevatorsInfo[i].split(":");
            Elevator elevator = new Elevator(elevatorSpecifications[0]);
            elevator.setCurrentFloor(Integer.parseInt(elevatorSpecifications[1]));
            elevators.add(elevator);


        }

    }

    public String requestElevator() {
        Elevator closestElevator = elevatorDispatcher.findClosestElevator(elevators, numberOfFloors);

        return closestElevator.getId();
    }

    public String requestElevator(int requestFloor) {
        Elevator closestElevator = elevatorDispatcher.findClosestElevator(elevators, requestFloor); 
        return closestElevator.getId();
    }

    public Stream<Elevator> findConvenientElevators() {
        return elevators.stream().filter(e -> !(e.getDirection().equals(down)) && !(e.getState().isStopped()));
    }

    public void move(String elevatorId, String direction) {
        Elevator elevator = elevators.stream().filter(e -> e.getId().equals(elevatorId)).findFirst().get();
        elevator.setDirection(direction);
    }

    public void stopAt(String elevatorId, int floor) {
        if (floor != numberOfFloors)
            elevators.stream().filter(e -> e.getId().equals(elevatorId)).forEach(Elevator :: stopElevator);


    }




}
