package com.sqli.main.elevators;

public class Elevator {
    private String id;
    private int currentFloor;
    private boolean isMoving;
    private ElevatorState state;


    public boolean isMoving() {
        return isMoving;
    }
    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }


    public int getCurrentFloor() {
        return currentFloor;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Elevator [id=" + id + ", currentFloor=" + currentFloor + ", isMoving=" + isMoving + ", state=" + state
                + "]";
    }
    public ElevatorState getState() {
        return state;
    }
    public Elevator(String id, int currentFloor) {
        super();
        this.id = id;
        this.currentFloor = currentFloor;
        this.state = new RestingState();
        this.isMoving = false;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

}