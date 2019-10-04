package com.sqli.main.elevators;

public class ElevatorState {
    private int floor;
    private String behaviour;
    private boolean stopped;


    public ElevatorState() {
        this.behaviour="REST";
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }


    public String getBehaviour() {
        return behaviour;
    }

    public void setBehaviour(String behaviour) {
        this.behaviour = behaviour;
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
