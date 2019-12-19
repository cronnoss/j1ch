package com.dzdz.web1ch.model;

public class FlightData {
    private String pnr;
    private String airlineCode;
    private String flightNum;
    private String date;
    private String flightTime;
    private String arrivalTime;
    private String departure;
    private String destination;
    private String firstName;
    private String lastName;
    private String middleName;
    private int indexOfCard;

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

    public String getMiddleName() {
        return middleName;
    }

    public int getIndexOfCard() {
        return indexOfCard;
    }

    public FlightData withPnr(String pnr) {
        this.pnr = pnr;
        return this;
    }

    public FlightData withAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
        return this;
    }

    public FlightData withFlightNum(String flightNum) {
        this.flightNum = flightNum;
        return this;
    }

    public FlightData withDate(String date) {
        this.date = date;
        return this;
    }

    public FlightData withFlightTime(String flightTime) {
        this.flightTime = flightTime;
        return this;
    }

    public FlightData withArrivalTime(String arrivalTime) {
        this.arrivalTime = arrivalTime;
        return this;
    }

    public FlightData withDeparture(String departure) {
        this.departure = departure;
        return this;
    }

    public FlightData withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public FlightData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public FlightData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public FlightData withMiddleName(String middleName) {
        this.middleName = middleName;
        return this;
    }

    public FlightData withIndexOfCard(int indexOfCard) {
        this.indexOfCard = indexOfCard;
        return this;
    }
}