package csc3020.lecture13.gp7633;

import csc3020.lecture12.gp7633.CargoFlight;
import csc3020.lecture13.gp7633.schurch.travel.Flight;
import csc3020.lecture13.gp7633.schurch.travel.Passenger;
import csc3020.lecture13.gp7633.xyzcompany.bar.*;

//import com.csc3020.Lecture13.gp7633.xyzcompany.bar.Beer;
//import com.csc3020.Lecture13.gp7633.xyzcompany.bar.Wine;

public class Lecture13Source {
    public static void main(String[] args) {
//        new com.csc3020.Lecture13.gp7633.Lecture13Source();
        Flight oFlight = new Flight();
        Flight oLecture11Flight = new Flight();
        CargoFlight oCargoFlight = new CargoFlight();

        Flight lax175 = new Flight(175);
        Beer liteBeer = new Beer();
        Passenger jane = new Passenger();
        Wine merlot = new Wine();

        lax175.getFlightNumber();
    }
}