package com.csc3020.lecture15.go5334;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;


public class Flight implements Comparable<Flight>,Iterable<Person> {
    static final int MAX_FAA_SEATS = 550;
    public int passengers;
    public int seats;
    private boolean[] isSeatAvailable;
    private Integer flightNumber;
    private Character flightClass;
    private int maxCarryOns, totalCarryOns;

    private int totalCheckedBags;
    private int flightTime;//minutes past midnight
    private CrewMember[] crew;
    private Passenger[] roster;


    {
        seats = 150;
        passengers = 0;
        isSeatAvailable = new boolean[seats];
        for (int index = 0; index < seats; index++) {
            isSeatAvailable[index] = true;
        }
        maxCarryOns = seats * 2;
        totalCarryOns = 0;
        totalCheckedBags = 0;
    }

    public Flight() {
    }

    public Flight(int flightNumber) {
        this();
        this.flightNumber = flightNumber;
    }

    public Flight(char flightClass) {
        this();
        this.flightClass = flightClass;
    }

    @Override
    public Iterator<Person> iterator() {
        //return  new FlightIterator(crew,roster);
        //return new FlightIterator();
        return new Iterator<Person>() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index<(crew.length+roster.length);
            }

            @Override
            public Person next() {
                Person person=(index<crew.length)?crew[index]:roster[index-crew.length];
                index++;
                return person;
            }
        };
    }

    @Override
    public String toString() {
        return "Flight{" +
                "passengers=" + passengers +
                ", seats=" + seats +
                ", flightNumber=" + flightNumber +
                ", flightClass=" + flightClass +
                ", maxCarryOns=" + maxCarryOns +
                ", totalCarryOns=" + totalCarryOns +
                ", totalCheckedBags=" + totalCheckedBags +
                ", flightTime=" + flightTime +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            return true;
        }
        if (!(o instanceof Flight)) {
            return false;
        }
        Flight other = (Flight) o;
        return
                flightClass == other.flightClass &&
                        flightNumber == other.flightNumber;
    }


    @Override
    public int compareTo(Flight o) {
        return flightTime-o.flightTime;

    }



    public int getSeat() {
        return 150;
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

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public void add1Passenger() {
        if (hasSeating()) {
            passengers += 1;
            allPassengers += 1;
        }
        else
            handleTooMany();
    }

    public void add1Passenger(int bags) {
        if (hasSeating()) {
            add1Passenger();
            totalCheckedBags += bags;
        }
    }

    public void add1Passenger(Passenger p) {
        add1Passenger(p.getCheckedBags());
    }

    public void add1Passenger(int bags, int carryOns) {
        if (hasSeating() && hasCarryOnSpace(carryOns)) {
            add1Passenger(bags);
            totalCarryOns += carryOns;
        }
    }

    public void add1Passenger(Passenger p, int carryOns) {
        add1Passenger(p.getCheckedBags(), carryOns);
    }

    public void addPassengers(String fileName) throws IOException {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = null;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                passengers += Integer.valueOf(parts[0]);
            }
        } finally {

            if (reader != null)
                reader.close();
        }
    }
    public void addRoster(Passenger[] roster){
        this.roster=roster;
    }
    public void addCrewMembers(CrewMember[] crew){
        this.crew=crew;
    }

    private boolean hasSeating() {
        return passengers < seats;
    }

    private boolean hasCarryOnSpace(int carryOns) {
        return totalCarryOns + carryOns <= maxCarryOns;
    }

    private void handleTooMany() {
        System.out.println("Too many!");
    }

    public boolean hasRoom(Flight f2) {
        int total = passengers + f2.passengers;
        return total <= seats;
    }

    public Flight createFlightWithBoth(Flight flight2) {
        Flight newFlight = new Flight();
        newFlight.seats = seats;
        newFlight.passengers = this.passengers + flight2.passengers;
        return newFlight;
    }

    public void print() {
        String str = "Flight[ seats= " + this.seats + ",passengers= " + this.passengers + "]";
        System.out.println(str);
    }

    static int allPassengers;
    static int getAllPassengers(){
        return allPassengers;
    }
    static int resetAllPassengers(){
        return allPassengers=0;
    }
}
