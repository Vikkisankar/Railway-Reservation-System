package com.RailwayRes;

public class TicketCounter {
    private static int ticketNumber = 1001;  // Starting ticket number

    public static int increment() {
        return ticketNumber++;  // Returns the current ticket number and then increments it for the next ticket
    }
}


