package csc3020.lecture12.av7071;

public class Passenger {
    private int checkedBags;
    private final int freeBags;

    public int getCheckedBags() {
        return checkedBags;
    }
    public void setCheckedBags(int checkedBags) {
        this.checkedBags = checkedBags;
    }

    public int getFreeBags() {
        return freeBags;
    }
//    public void setFreeBags(int freeBags) {
//        this.freeBags = freeBags;
//    }

    private double perBagFee;

    public double getPerBagFee() {
        return perBagFee;
    }

    public void setPerBagFee(double perBagFee) {
        this.perBagFee = perBagFee;
    }
    public Passenger(){
        freeBags = 0;
    }
    public Passenger(int freeBags){
        //this(freeBags>1?25.0d:50.0d);
//          if(freeBags>1){
//
//              perBagFee=25.0d;
//          }else{
//              perBagFee=50.0d;
//          }

        this.freeBags=freeBags;

    }
//    public Passenger(int freeBags, int checkedBags){
//        //this.freeBags=freeBags;
//        this(freeBags);
//        this.checkedBags=checkedBags;
//    }
//    private Passenger(double perBagFee){
//        this.perBagFee=perBagFee;
//    }
}
