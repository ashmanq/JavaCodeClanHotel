public class Booking {

    private Bedroom bedroom;
    private int noOfNights;

    public Booking(Bedroom bedroom, int noOfNights){
        this.bedroom = bedroom;
        this.noOfNights = noOfNights;
    }

    public Bedroom getBedroom() {
        return this.bedroom;
    }

    public int getNoOfNights() {
        return noOfNights;
    }

    public double getTotalBill(){
        double total = this.bedroom.getRate() * this.noOfNights;
        return total;
    }
}
