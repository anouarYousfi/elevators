package com.sqli.main.elevators;

public class RestingState implements ElevatorState {
    @Override
    public void up(Building building, Elevator elevator, int destination) {
        while (elevator.getCurrentFloor() != destination)
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);

    }

    @Override
    public void down(Building building, Elevator elevator, int destination) {
        while (elevator.getCurrentFloor() != destination)
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
    }

    @Override
    public void stop(Building building, Elevator elevator, int destination) {
        throw new IllegalStateException();
    }
}
