import java.util.ArrayList;

public class Hotel {

    private String name;
    private ArrayList<Bedroom> bedrooms;
    private ArrayList<ConferenceRoom> conferenceRooms;

    public Hotel(String name){
        this.name = name;
        bedrooms = new ArrayList<Bedroom>();
        conferenceRooms = new ArrayList<ConferenceRoom>();
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
}
