import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;
    private ArrayList<Booking> bedroomBookings;

    public Hotel(String name, ArrayList<Bedroom> bedrooms, ArrayList<ConferenceRoom> conferenceRooms){
        this.name = name;
        this.bedrooms = bedrooms;
        this.conferenceRooms = conferenceRooms;
        this.bedroomBookings = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public int getNoOfBedrooms() {
        return this.bedrooms.size();
    }

    public int getNoOfConferenceRooms() {
        return this.conferenceRooms.size();
    }

    public int doesBedroomExist(int bedroomNo){
        int index = -1;

        for(int i=0; i < getNoOfBedrooms(); i++){
            if(this.bedrooms.get(i).getRoomNo() == bedroomNo){
                index = i;
            }
        }

        return index;
    }

    public void checkInGuestToBedroom(Guest guest, int bedroomNo) {
        int indexOfBedroom = this.doesBedroomExist(bedroomNo);
        if(indexOfBedroom != -1){
            this.bedrooms.get(indexOfBedroom).addGuest(guest);
        }
    }

    public void checkOutGuestFromBedroom(int bedroomNo) {
        int indexOfBedroom = this.doesBedroomExist(bedroomNo);
        if(indexOfBedroom != -1){
            this.bedrooms.get(indexOfBedroom).checkOutGuests();
        }
    }


    public int doesConferenceRoomExist(String name){
        int index = -1;

        for(int i=0; i < getNoOfBedrooms(); i++){
            if(this.conferenceRooms.get(i).getName() == name){
                index = i;
            }
        }

        return index;
    }

    public void checkInGuestToConferenceRoom(Guest guest, String name) {
        int indexOfConferenceRoom = this.doesConferenceRoomExist(name);
        if(indexOfConferenceRoom != -1){
            this.conferenceRooms.get(indexOfConferenceRoom).addGuest(guest);
        }
    }

    public void checkOutGuestFromConferenceRoom(String name) {
        int indexOfConferenceRoom = this.doesConferenceRoomExist(name);
        if(indexOfConferenceRoom != -1){
            this.conferenceRooms.get(indexOfConferenceRoom).checkOutGuests();
        }
    }

    public int getNoOfBookings(){
        return this.bedroomBookings.size();
    }

    public Booking createBookingForBedroom(Bedroom bedroom, int noOfNights){
        if(this.bedrooms.contains(bedroom)){
            Booking booking = new Booking(bedroom, noOfNights);
            this.bedroomBookings.add(booking);
            return booking;
        }
        return null;
    }
}
