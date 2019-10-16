package com.sqli.main.elevators;

public class RestingState implements ElevatorState {
    @Override
    public void up(Building building, Elevator elevator, int destination) {
        if (elevator.getCurrentFloor() != destination) {
            elevator.setState(new GoingUpState());
            elevator.setCurrentFloor(elevator.getCurrentFloor() + 1);
            up(building, elevator, destination);
        } else
            elevator.setState(new RestingState());
    }


    @Override
    public void down(Building building, Elevator elevator, int destination) {
        if (elevator.getCurrentFloor() != destination) {
            elevator.setState(new GoingDownState());
            elevator.setCurrentFloor(elevator.getCurrentFloor() - 1);
            up(building, elevator, destination);
        } else
            elevator.setState(new RestingState());
    }

    @Override
    public void stop(Building building, Elevator elevator, int destination) {
        throw new IllegalStateException();
    }
}
