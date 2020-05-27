import java.util.ArrayList;

public class ConferenceRoom {
    private String name;
    private int capacity;
    private ArrayList<Guest> guests;

    public ConferenceRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.guests = new ArrayList<Guest>();
    }

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getNoGuestsInConferenceRoom() {
        return this.guests.size();
    }

    public boolean isFull(){
        return this.capacity <= this.getNoGuestsInConferenceRoom();
    }

    public void addGuest(Guest guest) {
        if(!isFull()){
            this.guests.add(guest);
        }
    }

    public void checkOutGuests() {
        this.guests.clear();
    }
}
