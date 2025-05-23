package com.RailwayRes;

import java.util.ArrayList;
import java.util.List;

public class Ticket {
    private int ticketNumber;
    private String trainName;

    private List<Passenger> lowerBerth;
    private List<Passenger> middleBerth;
    private List<Passenger> upperBerth;
    private List<Passenger> waitingList;

    private static final int MAX_BERTH_PER_TYPE = 5;
    private static final int MAX_WAITING_LIST = 5;

    public Ticket(String trainName, int ticketNumber) {
        this.trainName = trainName;
        this.ticketNumber = ticketNumber;
        this.lowerBerth = new ArrayList<>();
        this.middleBerth = new ArrayList<>();
        this.upperBerth = new ArrayList<>();
        this.waitingList = new ArrayList<>();
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public List<Passenger> getLowerBerth() {
        return lowerBerth;
    }

    public List<Passenger> getMiddleBerth() {
        return middleBerth;
    }

    public List<Passenger> getUpperBerth() {
        return upperBerth;
    }

    public List<Passenger> getWaitingList() {
        return waitingList;
    }

    public List<Passenger> getPassengerList() {
        List<Passenger> allPassengers = new ArrayList<>();
        allPassengers.addAll(lowerBerth);
        allPassengers.addAll(middleBerth);
        allPassengers.addAll(upperBerth);
        allPassengers.addAll(waitingList);
        return allPassengers;
    }

    public boolean isFull() {
        return lowerBerth.size() >= MAX_BERTH_PER_TYPE &&
               middleBerth.size() >= MAX_BERTH_PER_TYPE &&
               upperBerth.size() >= MAX_BERTH_PER_TYPE &&
               waitingList.size() >= MAX_WAITING_LIST;
    }

    public void addPassenger(Passenger passenger) {
        String preference = passenger.getBerthPreference().toLowerCase();

        switch (preference) {
            case "lower":
                if (lowerBerth.size() < MAX_BERTH_PER_TYPE) {
                    lowerBerth.add(passenger);
                    System.out.println("Ticket booked with Lower berth! Ticket number: " + ticketNumber);
                    return;
                }
                break;
            case "middle":
                if (middleBerth.size() < MAX_BERTH_PER_TYPE) {
                    middleBerth.add(passenger);
                    System.out.println("Ticket booked with Middle berth! Ticket number: " + ticketNumber);
                    return;
                }
                break;
            case "upper":
                if (upperBerth.size() < MAX_BERTH_PER_TYPE) {
                    upperBerth.add(passenger);
                    System.out.println("Ticket booked with Upper berth! Ticket number: " + ticketNumber);
                    return;
                }
                break;
        }

        // Assign any available berth if preferred not available
        if (lowerBerth.size() < MAX_BERTH_PER_TYPE) {
            lowerBerth.add(passenger);
            System.out.println("Preferred berth full. Assigned Lower berth. Ticket number: " + ticketNumber);
        } else if (middleBerth.size() < MAX_BERTH_PER_TYPE) {
            middleBerth.add(passenger);
            System.out.println("Preferred berth full. Assigned Middle berth. Ticket number: " + ticketNumber);
        } else if (upperBerth.size() < MAX_BERTH_PER_TYPE) {
            upperBerth.add(passenger);
            System.out.println("Preferred berth full. Assigned Upper berth. Ticket number: " + ticketNumber);
        } else if (waitingList.size() < MAX_WAITING_LIST) {
            waitingList.add(passenger);
            System.out.println("All berths full. Added to waiting list. Ticket number: " + ticketNumber);
        } else {
            System.out.println("No available berths or waiting list space. Booking failed.");
        }
    }

    public void cancelTicket() {
        lowerBerth.clear();
        middleBerth.clear();
        upperBerth.clear();
        waitingList.clear();
        System.out.println("All bookings under ticket number " + ticketNumber + " have been canceled.");
    }
}
