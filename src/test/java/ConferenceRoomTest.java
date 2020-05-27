import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConferenceRoomTest {

    private ConferenceRoom conferenceRoom1;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    @Before
    public void before(){
        conferenceRoom1 = new ConferenceRoom("Mordor Suite", 2);
        guest1 = new Guest("Frodo");
        guest2 = new Guest("Samwise");
        guest2 = new Guest("Sauron");
    }

    @Test
    public void hasName(){
        assertEquals("Mordor Suite", conferenceRoom1.getName());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, conferenceRoom1.getCapacity());
    }

    @Test
    public void startWithNoGuests(){
        assertEquals(0, conferenceRoom1.getNoGuestsInConferenceRoom());
    }

    @Test
    public void roomHasSpace(){
        assertEquals(false, conferenceRoom1.isFull());
    }

    @Test
    public void canAddGuest(){
        conferenceRoom1.addGuest(guest1);
        assertEquals(1, conferenceRoom1.getNoGuestsInConferenceRoom());
    }

    @Test
    public void roomIsFull(){
        conferenceRoom1.addGuest(guest1);
        conferenceRoom1.addGuest(guest2);
        assertEquals(true, conferenceRoom1.isFull());
    }

    @Test
    public void cantAddMoreGuestsThanCapacity(){
        conferenceRoom1.addGuest(guest1);
        conferenceRoom1.addGuest(guest2);
        conferenceRoom1.addGuest(guest3);
        assertEquals(true, conferenceRoom1.isFull());
        assertEquals(2, conferenceRoom1.getNoGuestsInConferenceRoom());
    }

    @Test
    public void canRemoveGuestsFromRoom(){
        conferenceRoom1.addGuest(guest1);
        conferenceRoom1.addGuest(guest2);
        conferenceRoom1.checkOutGuests();
        assertEquals(0, conferenceRoom1.getNoGuestsInConferenceRoom());
    }
}
