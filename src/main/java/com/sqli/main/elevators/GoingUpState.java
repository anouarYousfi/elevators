package com.sqli.main.elevators;

public class GoingUpState implements ElevatorState {
    @Override
    public void up(Building building, Elevator elevator, int destination) {
        if (elevator.getCurrentFloor() == building.getNumberOfFloors())
            elevator.setState(new GoingDownState());
    }

    @Override
    public void down(Building building, Elevator elevator, int destination) {
        throw new IllegalStateException();
    }

    @Override
    public void stop(Building building, Elevator elevator, int destination) {
        elevator.setState(new RestingState());
    }
}
