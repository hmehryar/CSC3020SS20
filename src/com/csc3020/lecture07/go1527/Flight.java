package com.csc3020.lecture07.go1527;

public class Flight {
    private int seats;
    private int passengers;
    private boolean[] isSeatAvailable;
    private int flightNumber;
    private char flightClass;

    {
        seats = 150;
        passengers = 0;
        isSeatAvailable = new boolean[seats];
        for (int i = 0; i < seats; i++) {
            isSeatAvailable[i] = true;
        }
    }
    public Flight() {}
    public Flight(int flightNumber) {
        this();
        this.flightNumber = flightNumber;
    }

    public Flight(char flightClass) {
        this();
        this.flightClass = flightClass;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public char getFlightClass() {
        return flightClass;
    }
    public void setFlightClass(char flightClass) {
        this.flightClass = flightClass;
    }
    public int getPassengers() {
        return passengers;
    }
    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }
    void add1Passenger() {
        if (passengers < seats)
            passengers += 1;
        else
            handleTooMany();
    }
    private void handleTooMany() {
        System.out.println("Too many!");
    }
    public boolean hasRoom(Flight f2) {
        int total = passengers + f2.passengers;
        return total <= seats;
    }
    public Flight createFlightWithBoth(Flight f2) {
        Flight newFlight = new Flight();
        newFlight.seats = seats;
        newFlight.passengers = this.passengers+f2.passengers;
        return newFlight;
    }
    public void print(){
        String str = "Flight [seats = "+this.seats+", passengers = "+this.passengers+"]";
        System.out.println(str);
    }
}
