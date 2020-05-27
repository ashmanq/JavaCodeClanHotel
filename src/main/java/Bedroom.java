import java.util.ArrayList;

public class Bedroom {

    private int roomNo;
    private int capacity;
    private ArrayList<Guest> guests;
    private String roomType;
    private Double rate;

    public Bedroom(int roomNo, int capacity, String roomType, Double rate) {
        this.roomNo = roomNo;
        this.capacity = capacity;
        this.roomType = roomType;
        this.guests = new ArrayList<Guest>();
        this.rate = rate;
    }

    public int getRoomNo() {
        return this.roomNo;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public String getRoomType() {
        return this.roomType;
    }

    public int getNoGuestsInRoom() {
        return this.guests.size();
    }

    public Double getRate() {
        return this.rate;
    }

    public void setRate(Double newRate) {
        this.rate = newRate;
    }

    public boolean isFull(){
        return this.capacity <= this.getNoGuestsInRoom();
    }

    public void addGuest(Guest guest) {
        if(!isFull()){
            this.guests.add(guest);
        }
    }

    public void checkOutGuests(){
        this.guests.clear();
    }
}
