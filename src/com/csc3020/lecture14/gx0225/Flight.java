package csc3020.lecture14.gx0225;

import java.io.BufferedReader;

import java.io.FileReader;

import java.io.IOException;

import java.util.Iterator;



public class Flight implements Comparable<Flight>, Iterable<Person>{

    protected int legacyFlightNumber;

    static final int MAX_FAA_SEATS = 550;

    private int passengers;

//    public int seats;

    private int seats;

    private boolean[] isSeatAvailable;

    private int totalCarryOns;

    private int maxCarryOns;

    private int totalCheckedBags;

    private int flightTime; // minutes past midnight

    private CrewMember[] crew;

    private Passenger[] roster;



    private Integer flightNumber;

    private Character flightClass;

    {

        seats = 150;

        maxCarryOns = 2 * seats;

        passengers = 0;

        isSeatAvailable = new boolean[seats];

        for (int index = 0; index < seats; index++) {

            isSeatAvailable[index] = true;

        }

        totalCarryOns = 0;

        totalCheckedBags = 0;

    } // initialization block



    public Flight() {



    }



//    public Flight(int seats){

//        isSeatAvailable = new boolean[seats];

//        for (int index = 0; index < seats; index++) {

//            isSeatAvailable[index] = true;

//        }

//        //setSeats(seats);

//        this.seats = seats;

//        passengers = 0;

//    }



    public Flight(int flightNumber){

        this();

        this.flightNumber = flightNumber;

    }

    public Flight(char flightClass){

        this();

        this.flightClass = flightClass;

    }



//    @Override

//    public int compareTo(Object o) {

//        Flight f = (Flight) o;

//        if (flightTime < f.flightTime)

//            return -1;

//        else if (flightTime > f.flightTime)

//            return 1;

//        else

//            return 0;

//    }





    @Override

    public int compareTo(Flight o) {

        return flightTime - o.flightTime;

//        if (flightTime < o.flightTime)

//            return -1;

//        else if (flightTime > o.flightTime)

//            return 1;

//        else

//            return 0;

    }





//    @Override

//    public String toString(){

//        if (flightNumber != null){

//            return "Flight #" + flightNumber;

//        } else if (flightClass != null){

//            return "Flight Class" + flightClass;

//        } else {

//            return "Flight identity is not set";

//

//        }

//    }



    @Override

    public String toString() {

        return "Flight{" +

                "passengers=" + passengers +

                ", seats=" + seats +

                ", maxCarryOns=" + maxCarryOns +

                ", totalCheckedBags=" + totalCheckedBags +

                ", flightTime=" + flightTime +

                ", flightNumber=" + flightNumber +

                ", flightClass=" + flightClass +

                '}';

    }



    @Override

    public Iterator<Person> iterator() {

        return new FlightIterator(crew, roster);

    }



//    @Override

//    public String toString() {

//        return "Flight{" +

//                "flightNumber=" + flightNumber +

//                '}';

//    }



    @Override

    public boolean equals(Object o){

        if (super.equals(o)){

            return true;

        }

        if (!(o instanceof Flight)) {

            return false;

        }



        Flight other = (Flight) o;

        return flightClass == other.flightClass

                && flightNumber == other.flightNumber;



    }



    public int getSeats(){

        return 150;

    }

    public void setSeats(int seats){

        this.seats = seats;

    }

    public int getPassengers() {

        return passengers;

    }

    public void setPassengers(int passengers) {

        this.passengers = passengers;

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

    public int getFlightTime() {

        return flightTime;

    }

    public void setFlightTime(int flightTime) {

        this.flightTime = flightTime;

    }



    public void add1Passenger() {

        if (hasSeating())

            passengers += 1;

        else

            handleTooMany();

    }

    public void add1Passenger(int bags){

        if (hasSeating()){

            add1Passenger();

            totalCheckedBags += bags;

        }

    }

    public void add1Passenger(Passenger p){

        add1Passenger(p.getCheckedBags());

    }

    public void add1Passenger(int bags, int carryOns){

        if (hasSeating() && hasCarryOnSpace(carryOns)){

            add1Passenger(bags);

            totalCarryOns += carryOns;

        }

    }

    public void add1Passenger(Passenger p, int carryOns){

        add1Passenger(p.getCheckedBags(), carryOns);

    }



    public void addPassengers(String filename) throws IOException {

        BufferedReader reader = null;

        try {

            reader = new BufferedReader(new FileReader(filename));

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



    private boolean hasSeating(){

        return passengers < seats;

    }

    private boolean hasCarryOnSpace(int carryOns){

        return totalCarryOns + carryOns <= maxCarryOns;

    }

    private void handleTooMany() {

        System.out.println("Too many!");

    }



    public boolean hasRoom(Flight f2) {

        int total = passengers + f2.passengers;

        return total <= seats;

    }

    public Flight createFlightWithBoth(Flight flight2){

        Flight oFlight = new Flight();

        oFlight.seats = seats;

        oFlight.passengers = passengers + flight2.passengers;

        return oFlight;

    }

    public void print(){

        String str = "Flight[seats = " + this.seats + ", passengers = " + this.passengers + "]";

        System.out.println(str);

    }

    public void addRoster(Passenger[] roster){

        this.roster = roster;

    }





    public void AddCrewMembers(CrewMember[] crew) {

        this.crew = crew;

    }
}
