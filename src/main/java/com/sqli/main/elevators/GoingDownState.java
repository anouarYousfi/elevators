package com.sqli.main.elevators;

public class GoingDownState implements ElevatorState {
    @Override
    public void up(Building building, Elevator elevator, int destination) {
        throw new IllegalStateException();
    }

    @Override
    public void down(Building building, Elevator elevator, int destination) {
        if (elevator.getCurrentFloor() == 0) {
            elevator.setState(new GoingUpState());
        }
        while (elevator.getCurrentFloor() != destination) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
        }
    }

    @Override
    public void stop(Building building, Elevator elevator, int destination) {

    }
}
