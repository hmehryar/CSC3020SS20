package csc3020.lecture14.gr4381;

public class Passenger extends Person implements Comparable<Passenger>{
    private int checkedBags;
    private final int freeBags;
    private double perBagFee;
    private Flight relatedFlight;

    private int memberLevel; // 3 (1st priority), 2, 1
    private int memberDays;

    public void setCheckedBags(int checkedBags){
        this.checkedBags = checkedBags;
    }
    public int getCheckedBags() {
        return checkedBags;
    }
//    public void setFreeBags(int freeBags) {
//        this.freeBags = freeBags;
//    }
    public int getFreeBags() {
        return freeBags;
    }
    public void setPerBagFee(double perBagFee) {
        this.perBagFee = perBagFee;
    }
    public double getPerBagFee() {
        return perBagFee;
    }

    public void setMemberLevel(int memberLevel) {
        this.memberLevel = memberLevel;
    }
    public void setMemberDays(int memberDays) {
        this.memberDays = memberDays;
    }
    public int getMemberLevel() {
        return memberLevel;
    }
    public int getMemberDays() {
        return memberDays;
    }

    public Passenger(){
        freeBags = 0;
        relatedFlight = new Flight();
        relatedFlight.legacyFlightNumber = 0;
    }
    public Passenger(int freeBags){
//        this(freeBags > 1 ? 25.0d : 50.0d);
//        if (freeBags > 1){
//            perBagFee = 25.0d;
//        } else{
//            perBagFee = 50.0d;
//        }
        this.freeBags = freeBags;
    }
    public Passenger(int freeBags, int checkedBags){
        //this.freeBags = freeBags;
        this(freeBags); // chained constructor
        this.checkedBags = checkedBags;
    }

    @Override
    public int compareTo(Passenger p) {
        //Passenger p = (Passenger) o;
        if (memberLevel > p.memberLevel)
            return -1;
        else if (memberLevel < p.memberLevel)
            return 1;
        else {
            if (memberDays > p.memberDays)
                return -1;
            else if (memberDays < p.memberDays)
                return 1;
            else
                return 0;
        }

    }

    public void setMemberLevelAndDays(int level, int days) {
        setMemberLevel(level);
        setMemberDays(days);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "checkedBags=" + checkedBags +
                ", freeBags=" + freeBags +
                ", perBagFee=" + perBagFee +
                ", memberLevel=" + memberLevel +
                ", memberDays=" + memberDays +
                '}';
    }
    //    private Passenger(double perBagFee){
//        this.perBagFee = perBagFee;
//    }


}
