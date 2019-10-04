package com.sqli.main.elevators;


import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Building {
    private static final Logger LOG = Logger.getLogger(String.valueOf(Building.class));
    private static String down = "DOWN";
    private int numberOfFloors;
    private List<Elevator> elevators;

    public Building(int numberOfFloors, String... elevatorsInfo) {
        this.numberOfFloors = numberOfFloors;
        elevators = new ArrayList<>();
        for (int i = 0; i < elevatorsInfo.length; i++) {
            String[] elevatorSpecifications;
            elevatorSpecifications = elevatorsInfo[i].split(":");
            Elevator elevator = new Elevator(elevatorSpecifications[0]);
            elevator.setFloorState(Integer.parseInt(elevatorSpecifications[1]));
            elevators.add(elevator);


        }

    }

    public String requestElevator() {
        Elevator closestElevator;
        closestElevator = findConvenientElevators().min(Comparator.comparing(e -> e.distanceBetweenFloors(numberOfFloors))).get();
        return closestElevator.getId();
    }

    public String requestElevator(int currentFloor) {
        Elevator closestElevator;

        closestElevator = findConvenientElevators().min(Comparator.comparing(e -> e.distanceBetweenFloors(currentFloor))).get();
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
