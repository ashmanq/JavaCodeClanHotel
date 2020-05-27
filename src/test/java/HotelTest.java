import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class HotelTest {

    private Hotel hotel1;
    private Bedroom bedroom1;
    private Bedroom bedroom2;
    private ConferenceRoom conferenceRoom1;
    private ConferenceRoom conferenceRoom2;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    @Before
    public void before(){

        guest1 = new Guest("Aragorn");
        guest2 = new Guest("Merry");
        guest3 = new Guest("Pippin");
        bedroom1 = new Bedroom(1, 2, "Double", 10.00);
        bedroom2 = new Bedroom(2, 2, "Double", 15.00);
        conferenceRoom1 = new ConferenceRoom("The Mines of Moria", 3);
        conferenceRoom2 = new ConferenceRoom("Rivendell", 4);

        ArrayList<Bedroom> bedrooms = new ArrayList<Bedroom>(){
            {
                add(bedroom1);
            }
        };

        ArrayList<ConferenceRoom> conferenceRooms = new ArrayList<ConferenceRoom>(){
            {
                add(conferenceRoom1);
            }
        };

        hotel1 = new Hotel("The Prancing Pony", bedrooms, conferenceRooms);

    }

    @Test
    public void hasName(){
        assertEquals("The Prancing Pony", hotel1.getName());
    }

    @Test
    public void hasBedrooms(){
        assertEquals(1, hotel1.getNoOfBedrooms());
    }

    @Test
    public void hasConferenceRooms(){
        assertEquals(1, hotel1.getNoOfConferenceRooms());
    }

    @Test
    public void bedroomExists(){
        assertNotEquals(-1, hotel1.doesBedroomExist(1));
    }

    @Test
    public void bedroomDoesNotExist(){
        assertEquals(-1, hotel1.doesBedroomExist(3));
    }

    @Test
    public void canCheckInGuestIntoBedroomThatExists(){
        hotel1.checkInGuestToBedroom(guest1, 1);
        assertEquals(1, bedroom1.getNoGuestsInRoom());
    }

    @Test
    public void cantCheckInGuestIntoBedroomThatDoesNotExist(){
        hotel1.checkInGuestToBedroom(guest1, 4);
        assertEquals(0, bedroom1.getNoGuestsInRoom());
    }

    @Test
    public void canCheckOutGuestsFromBedroom(){
        hotel1.checkInGuestToBedroom(guest1, 1);
        hotel1.checkInGuestToBedroom(guest2, 1);
        hotel1.checkOutGuestFromBedroom(1);
        assertEquals(0, bedroom1.getNoGuestsInRoom());
    }

    @Test
    public void conferenceRoomExists(){
        assertNotEquals(-1, hotel1.doesConferenceRoomExist("The Mines of Moria"));
    }

    @Test
    public void conferenceRoomDoesNotExist(){
        assertEquals(-1, hotel1.doesConferenceRoomExist("Michael's Place"));
    }

    @Test
    public void canCheckInGuestIntoConferenceRoomThatExists(){
        hotel1.checkInGuestToConferenceRoom(guest1, "The Mines of Moria");
        assertEquals(1, conferenceRoom1.getNoGuestsInConferenceRoom());
    }

    @Test
    public void cantCheckInGuestToConferenceRoomThatDoesNotExist(){
        hotel1.checkInGuestToConferenceRoom(guest1, "Ash's Room");
        assertEquals(0, conferenceRoom1.getNoGuestsInConferenceRoom());
    }

    @Test
    public void canCheckOutGuestsFromConferenceRoom(){
        hotel1.checkInGuestToConferenceRoom(guest1, "Rivendell");
        hotel1.checkInGuestToConferenceRoom(guest2, "Rivendell");
        hotel1.checkOutGuestFromConferenceRoom("Rivendell");
        assertEquals(0, conferenceRoom2.getNoGuestsInConferenceRoom());
    }

    @Test
    public void bedroomBookingsStartAtZero(){
        assertEquals(0, hotel1.getNoOfBookings());
    }

    @Test
    public void canBookBedroom(){
        hotel1.createBookingForBedroom(bedroom1, 4);
        assertEquals(1, hotel1.getNoOfBookings());
    }
}
