package com.csc3020.lecture06.gh9762;

public class Lecture06Source {
    public static void main(String[] args){
        com.csc3020.lecture06.hm.Flight oFlight1=new com.csc3020.lecture06.hm.Flight();
        for (int count = 0; count <20 ; count++) {
            oFlight1.add1Passenger();
        }
        com.csc3020.lecture06.hm.Flight oFlight2=new com.csc3020.lecture06.hm.Flight();
        for (int count = 0; count <30 ; count++) {
            oFlight1.add1Passenger();
        }
        boolean flight1HasRoom= oFlight1.hasRoom(oFlight2);
        System.out.println(flight1HasRoom);

        oFlight2=new com.csc3020.lecture06.hm.Flight();
        for (int count = 0; count < 131; count++) {
            oFlight2.add1Passenger();
        }
        flight1HasRoom= oFlight1.hasRoom(oFlight2);
        System.out.println(flight1HasRoom);

        oFlight2=new com.csc3020.lecture06.hm.Flight();
        oFlight2.add1Passenger();
        oFlight1.print();
        com.csc3020.lecture06.hm.Flight oMergedFlight= oFlight1.createFlightWithBoth(oFlight2);
        oFlight1.print();
        oMergedFlight.print();

        com.csc3020.lecture06.hm.Flight lax1=new com.csc3020.lecture06.hm.Flight();
        com.csc3020.lecture06.hm.Flight lax2=new com.csc3020.lecture06.hm.Flight();

        //Adding Passengers
        for (int count = 0; count <20; count++) {
            lax1.add1Passenger();
        }
//        for (int count = 0; count <30; count++) {
//            lax2.add1Passenger();
//        }
        for (int count = 0; count <131; count++) {
            lax2.add1Passenger();
        }
        lax1.print();
        lax2.print();
        //Flight lax3=Flight;
        com.csc3020.lecture06.hm.Flight lax3=null;
        if(lax1.hasRoom(lax2)){
            lax3=lax1.createFlightWithBoth(lax2);
        }
        if(lax3!=null)
            lax3.print();
        else
            System.out.println("The flights haven't merged!!");


        //Accessors and Mutator
        com.csc3020.lecture06.gh9762.Flight slcToNyc=new Flight();
        slcToNyc.setSeats(250);
        System.out.println(slcToNyc.getSeat());

    }
}
