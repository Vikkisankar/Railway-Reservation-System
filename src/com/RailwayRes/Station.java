package com.RailwayRes;

public class Station {
    private String name;
    private String arrivalTime;
    private String departureTime;

    public Station(String name, String arrivalTime, String departureTime) {
        this.name = name;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public String getName() {
        return name;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    @Override
    public String toString() {
        return name + " (Arr: " + arrivalTime + ", Dep: " + departureTime + ")";
    }
}
