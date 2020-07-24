package csc3020.lecture05.hc7391;

public class Flight {
    public  int passengers;
    public int seats;

    public Flight() {
        seats = 150;
        passengers = 0;
    }

    public void add1Passenger(){
        if(passengers < seats){
            passengers+= 1;
        }else{
            handleTooMany();
        }
    }

    private void handleTooMany(){
        System.out.println("Too Many Passengers!");
    }

    public boolean hasRoom(Flight f2){
        int total = passengers +f2.passengers;
        return total <= seats;
    }
}//end class
