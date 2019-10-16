package com.sqli.main.elevators;

public class GoingDownState implements ElevatorState {
    @Override
    public void up(Building building, Elevator elevator, int destination) {
        if (elevator.getCurrentFloor() == building.getNumberOfFloors())
            elevator.setState(new GoingDownState());
        else throw new IllegalStateException();
    }

    @Override
    public void down(Building building, Elevator elevator, int destination) {
        if (elevator.getCurrentFloor() != destination) {
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            up(building, elevator, destination);
        } else
            elevator.setState(new RestingState());
    }

    @Override
    public void stop(Building building, Elevator elevator, int destination) {
        elevator.setState(new RestingState());
    }
}
