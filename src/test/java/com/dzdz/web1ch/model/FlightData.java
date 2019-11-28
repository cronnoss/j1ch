package com.dzdz.web1ch.model;

public class FlightData {
    private final String pnr;
    private final String airlineCode;
    private final String flightNum;
    private final String date;
    private final String flightTime;
    private final String arrivalTime;
    private final String departure;
    private final String destination;
    private final String firstName;
    private final String lastName;

    public FlightData(String pnr, String airlineCode, String flightNum, String date, String flightTime, String arrivalTime, String departure, String destination, String firstName, String lastName) {
        this.pnr = pnr;
        this.airlineCode = airlineCode;
        this.flightNum = flightNum;
        this.date = date;
        this.flightTime = flightTime;
        this.arrivalTime = arrivalTime;
        this.departure = departure;
        this.destination = destination;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getPnr() {
        return pnr;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

    public String getFlightNum() {
        return flightNum;
    }

    public String getDate() {
        return date;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public String getArrivalTime() {
        return arrivalTime;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDestination() {
        return destination;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
