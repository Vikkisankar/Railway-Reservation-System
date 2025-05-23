package com.RailwayRes;

import java.util.*;

public class RailwayReservationSystem {
    private static final Scanner sc = new Scanner(System.in);
    private static final Map<String, Train> trainMap = new HashMap<>();

    public static void main(String[] args) {
        // Pre-load a few trains
        trainMap.put("Express 101", new Train("Express 101"));
        trainMap.put("Express 202", new Train("Express 202"));

        while (true) {
            System.out.println("\n==== Railway Reservation System ====");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show Available Tickets");
            System.out.println("4. View Booked Passengers");
            System.out.println("5. Search Ticket");
            System.out.println("6. Display All Tickets");
            System.out.println("7. View Train Schedule");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    bookTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    showAvailableTickets();
                    break;
                case 4:
                    viewBookedPassengers();
                    break;
                case 5:
                    searchTicket();
                    break;
                case 6:
                    displayAllTickets();
                    break;
                case 7:
                    viewTrainSchedule();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Train selectTrain() {
        System.out.println("Available trains:");
        for (String name : trainMap.keySet()) {
            System.out.println("- " + name);
        }
        System.out.print("Enter train name: ");
        String trainName = sc.nextLine();

        Train train = trainMap.get(trainName);
        if (train == null) {
            System.out.println("Train not found.");
        }
        return train;
    }

    private static void bookTicket() {
        Train train = selectTrain();
        if (train == null) return;

        System.out.print("Enter passenger name: ");
        String name = sc.nextLine();

        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter berth preference (Lower, Middle, Upper): ");
        String berthPref = sc.nextLine();

        Passenger passenger = new Passenger(name, age, gender, berthPref);
        train.bookTicket(passenger);
    }

    private static void cancelTicket() {
        Train train = selectTrain();
        if (train == null) return;

        System.out.print("Enter ticket number to cancel: ");
        int ticketNumber = sc.nextInt();
        sc.nextLine();
        train.cancelTicket(ticketNumber);
    }

    private static void showAvailableTickets() {
        Train train = selectTrain();
        if (train != null) {
            train.showAvailableTickets();
        }
    }

    private static void viewBookedPassengers() {
        Train train = selectTrain();
        if (train != null) {
            train.viewBookedPassengers();
        }
    }

    private static void searchTicket() {
        Train train = selectTrain();
        if (train == null) return;

        System.out.print("Enter ticket number to search: ");
        int ticketNumber = sc.nextInt();
        sc.nextLine();

        train.searchTicket(ticketNumber);
    }

    private static void displayAllTickets() {
        Train train = selectTrain();
        if (train != null) {
            train.displayAllTickets();
        }
    }

    private static void viewTrainSchedule() {
        Train train = selectTrain();
        if (train != null) {
            train.displayTrainSchedule();
        }
    }
}
