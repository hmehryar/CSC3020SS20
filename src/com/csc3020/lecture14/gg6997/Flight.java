package csc3020.lecture14.gg6997;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

public class Flight implements Comparable<Flight>, Iterable<csc3020.lecture14.gg6997.Person>{
    static final int MAX_FAA_SEATS = 550;
    private int passengers;
    public int seats;
    private boolean[] isSeatAvailable;
    private int flightNumber;
    private Character flightClass;
    private int maxCarryOns, totalCarryOns;
    private int totalCheckedBags;
    private int flightTime; //minutes past midnight
    private csc3020.lecture14.gg6997.CrewMember[] crew;
    private csc3020.lecture14.gg6997.Passenger[] roster;

    {
        seats = 150;
        passengers = 0;
        isSeatAvailable = new boolean[seats];
        for (int i = 0; i < seats; i++) {
            isSeatAvailable[i] = true;
        }
        totalCarryOns = 0;
        totalCheckedBags = 0;
        maxCarryOns = seats * 2;
    }

    public Flight() {

    }

//    public Flight(int seats) {
//        //setSeats(seats);
//        this.seats = seats;
//        isSeatAvailable = new boolean[seats];
//        for (int i = 0; i < seats; i++) {
//            isSeatAvailable[i] = true;
//        }
//    }

    public Flight(int flightNumber) {
        this();
        this.flightNumber = flightNumber;
    }

    public Flight(char flightClass) {
        this();
        this.flightClass = flightClass;
    }

//    @Override
//    public int compareTo(Object o) {
//        Flight flight = (Flight) o;
//        if (flightTime < flight.flightTime) {
//            return -1;
//        }
//        else if (flightTime > flight.flightTime) {
//            return 1;
//        }
//        else {
//            return 0;
//        }
//    }

    @Override
    public int compareTo(Flight f) {
        return flightTime - f.flightTime;
    }

    @Override
    public Iterator<csc3020.lecture14.gg6997.Person> iterator() {
        return new csc3020.lecture14.gg6997.FlightIterator(crew, roster);
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

    //    @Override
//    public String toString() {
//        return "Flight{" +
//                "flightNumber=" + flightNumber +
//                ", flightClass=" + flightClass +
//                '}';
//        if (flightNumber > 0) {
//            return "Flight #" + flightNumber;
//        } else if (flightClass != null){
//            return "Flight Class " + flightClass;
//        }else {
//            return "Flight identity is not set";
//        }
//    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o)) {
            return true;
        }
        if (!(o instanceof Flight)){
            return false;
        }
        Flight other = (Flight) o;
        return flightClass == other.flightClass &&
                flightNumber == other.flightNumber;
    }

    public void print() {
        System.out.println("Flight[ seats = " + seats + ", passengers = " + passengers + "]");
    }

    public void addCrewMembers(csc3020.lecture14.gg6997.CrewMember[] crew) {
        this.crew = crew;
    }

    public void addPassengers(csc3020.lecture14.gg6997.Passenger[] roster) {
        this.roster = roster;
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
            if (reader != null) {
                reader.close();
            }
        }
    }

    public void add1Passenger() {
        if (hasSeating()) {
            passengers++;
        }
        else {
            handleTooMany();
        }
    }

    public void add1Passenger(int bags) {
        if (hasSeating()) {
            add1Passenger();
            totalCheckedBags += bags;
        }
    }

    public void add1Passenger(csc3020.lecture14.gg6997.Passenger p) {
        add1Passenger(p.getCheckedBags());
    }

    public void add1Passenger(int bags, int carryOns) {
        if (hasSeating() && hasCarryOnSpace(carryOns)) {
            add1Passenger(bags);
            totalCarryOns += carryOns;
        }
    }

    public void add1Passenger(csc3020.lecture14.gg6997.Passenger p, int carryOns) {
        add1Passenger(p.getCheckedBags(), carryOns);
    }

    private boolean hasSeating() {
        return passengers < seats;
    }

    public void handleTooMany() {
        System.out.println("Has too many!");
    }

    private boolean hasCarryOnSpace(int carryOns) {
        return totalCarryOns + carryOns <= maxCarryOns;
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

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        if (seats <= MAX_FAA_SEATS) {
            this.seats = seats;
        } else {
            //handle error
        }

    }

    public int getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(int flightTime) {
        this.flightTime = flightTime;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

}