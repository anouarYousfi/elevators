package com.sqli.main.elevators;

public class Elevator {
    private String id;
    private ElevatorState state;


    public Elevator(String id) {
        this.id = id;
        this.state = new ElevatorState();
    }

    public String getId() {
        return id;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setFloorState(int floor) {
        state.setFloor(floor);
    }

    public void setDirection(String direction) {
        state.setBehaviour(direction);
    }

    public String getDirection() {
        return state.getBehaviour();
    }

    public int distanceBetweenFloors(int currentFloor) {
        return Math.abs(currentFloor - state.getFloor());
    }

    public void stopElevator() {
        this.state.setStopped(true);
    }
}
