package com.RailwayRes;

import java.util.*;

public class Train {
    private String trainName;
    private int ticketCounter;
    private Map<Integer, Ticket> tickets;

    public Train(String trainName) {
        this.trainName = trainName;
        this.ticketCounter = 1001;
        this.tickets = new HashMap<>();
    }

    public String getTrainName() {
        return trainName;
    }

    public Map<Integer, Ticket> getTickets() {
        return tickets;
    }

    public void bookTicket(Passenger passenger) {
        // Try to add to an existing ticket with space
        for (Ticket ticket : tickets.values()) {
            if (!ticket.isFull()) {
                ticket.addPassenger(passenger);
                return;
            }
        }

        // Create a new ticket if no existing one has space
        Ticket newTicket = new Ticket(trainName, ticketCounter);
        newTicket.addPassenger(passenger);
        tickets.put(ticketCounter, newTicket);
        ticketCounter++;
    }

    public void cancelTicket(int ticketNumber) {
        Ticket ticket = tickets.get(ticketNumber);
        if (ticket != null) {
            ticket.cancelTicket();
            tickets.remove(ticketNumber);
            System.out.println("Ticket " + ticketNumber + " cancelled.");
        } else {
            System.out.println("Ticket not found.");
        }
    }

    public void showAvailableTickets() {
        int available = 0;
        for (Ticket ticket : tickets.values()) {
            if (!ticket.isFull()) {
                available++;
            }
        }
        System.out.println("Available tickets for train " + trainName + ": " + available);
    }

    public void viewBookedPassengers() {
        System.out.println("Booked passengers for " + trainName + ":");
        for (Ticket ticket : tickets.values()) {
            if (!ticket.getPassengerList().isEmpty()) {
                System.out.println("Ticket Number: " + ticket.getTicketNumber());
                printPassengerList("Lower Berth", ticket.getLowerBerth());
                printPassengerList("Middle Berth", ticket.getMiddleBerth());
                printPassengerList("Upper Berth", ticket.getUpperBerth());
                printPassengerList("Waiting List", ticket.getWaitingList());
                System.out.println();
            }
        }
    }

    private void printPassengerList(String berthType, List<Passenger> list) {
        if (!list.isEmpty()) {
            System.out.println("  " + berthType + ":");
            for (Passenger p : list) {
                System.out.println("    Name: " + p.getName() + ", Age: " + p.getAge() + ", Gender: " + p.getGender());
            }
        }
    }

    public void searchTicket(int ticketNumber) {
        Ticket ticket = tickets.get(ticketNumber);
        if (ticket != null) {
            System.out.println("Ticket Number: " + ticket.getTicketNumber() + ", Train: " + trainName);
            List<Passenger> all = ticket.getPassengerList();
            if (!all.isEmpty()) {
                for (Passenger p : all) {
                    System.out.println("Name: " + p.getName() + ", Age: " + p.getAge() + ", Gender: " + p.getGender());
                }
            } else {
                System.out.println("No passengers on this ticket.");
            }
        } else {
            System.out.println("Ticket not found.");
        }
    }

    public void displayAllTickets() {
        System.out.println("All tickets for train: " + trainName);
        for (Ticket ticket : tickets.values()) {
            System.out.println("Ticket Number: " + ticket.getTicketNumber() + " - " + (ticket.getPassengerList().isEmpty() ? "Available" : "Booked"));
        }
    }

    public void displayTrainSchedule() {
        System.out.println("Train Schedule for " + trainName + ":");
        if (trainName.equalsIgnoreCase("Express 101")) {
            System.out.println("Mumbai (Arr: 09:00, Dep: 09:10)");
            System.out.println("Pune (Arr: 11:30, Dep: 11:40)");
            System.out.println("Solapur (Arr: 14:00, Dep: 14:10)");
            System.out.println("Hyderabad (Arr: 18:30, Dep: 18:45)");
        } else if (trainName.equalsIgnoreCase("Express 202")) {
            System.out.println("Chennai (Arr: 08:00, Dep: 08:10)");
            System.out.println("Vellore (Arr: 10:00, Dep: 10:05)");
            System.out.println("Bangalore (Arr: 13:00, Dep: 13:10)");
            System.out.println("Mysore (Arr: 16:00, Dep: 16:15)");
        } else {
            System.out.println("Schedule not available.");
        }
    }
}
