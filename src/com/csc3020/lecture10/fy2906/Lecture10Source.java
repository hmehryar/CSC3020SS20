package csc3020.lecture10.fy2906;

public class Lecture10Source {
    public static void main(String[] args) {
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        if (flight1 == flight2) {
            System.out.println("Yes");
        }
        if (flight1.equals(flight2)) {
            System.out.println("Yes");
        }

        Passenger passenger = new Passenger();
        if (flight1.equals(passenger)) {
            System.out.println("Yes");
        }
        else
            System.out.println("No");

        //final

        //abstract
        //Person oPerson = new Person();
        Student oStudent = new Student();

//        Pilot oPilot = new Pilot();
        CargoOnlyPilot oCargoOnlyPilot = new CargoOnlyPilot();
        CargoFlight oCargoFlight = new CargoFlight();
        boolean canAccept = oCargoOnlyPilot.canAccept(oCargoFlight);
        if (canAccept) {
            System.out.println("The pilot can accept the flight");
        }
        else {
            System.out.println("The pilot can't accept the flight");
        }
        oCargoFlight.add1Passenger();
        canAccept = oCargoOnlyPilot.canAccept(oCargoFlight);
        if (canAccept) {
            System.out.println("The CargoOnlyPilot can accept the flight");
        }
        else {
            System.out.println("The CargoOnlyPilot can't accept the flight");
        }
        FullLicensePilot oFullLicensePilot = new FullLicensePilot();
        canAccept = oFullLicensePilot.canAccept(oCargoFlight);
        if (canAccept) {
            System.out.println("The FullLicensePilot can accept the flight");
        }
        else {
            System.out.println("The FullLicensePilot can't accept the flight");
        }
        Flight f175 = new Flight(125);
        CargoFlight cf = new CargoFlight();
        CargoFlight cf294 = new CargoFlight(294);
        CargoFlight cf85 = new CargoFlight(85, 2000.0f);
        CargoFlight cfBig = new CargoFlight(5000.0f);
    }
}
