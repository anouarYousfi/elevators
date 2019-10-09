package com.sqli.main.elevators;

public final class Elevator extends GoingDownState {
    private String id;
    private ElevatorState state;
    private int currentFloor;



    public Elevator(String id) {
        this.id = id;
        this.state = new RestingState();
    }

    public void setStateByFloor(int requestFloor){
        if(requestFloor>currentFloor)
            this.state=new GoingUpState();
        if (requestFloor<currentFloor)
            this.state=new GoingDownState();
        else
            this.state=new RestingState();
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public ElevatorState getState() {
        return state;
    }

    public void setState(ElevatorState state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

  public void moveUp(){}
  public void moveDown(){}
}
