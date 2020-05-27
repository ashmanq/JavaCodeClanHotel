import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BedroomTest {

    private Bedroom bedroom1;
    private Guest guest1;
    private Guest guest2;
    private Guest guest3;

    @Before
    public void before(){
        bedroom1 = new Bedroom(1, 2, "Double");
        guest1 = new Guest("Frodo");
        guest2 = new Guest("Samwise");
        guest2 = new Guest("Sauron");
    }

    @Test
    public void hasRoomNo(){
        assertEquals(1, bedroom1.getRoomNo());
    }

    @Test
    public void hasCapacity(){
        assertEquals(2, bedroom1.getCapacity());
    }

    @Test
    public void hasRoomType(){
        assertEquals("Double", bedroom1.getRoomType());
    }

    @Test
    public void startWithNoGuests(){
        assertEquals(0, bedroom1.getNoGuestsInRoom());
    }

    @Test
    public void roomHasSpace(){
        assertEquals(false, bedroom1.isFull());
    }

    @Test
    public void canAddGuest(){
        bedroom1.addGuest(guest1);
        assertEquals(1, bedroom1.getNoGuestsInRoom());
    }

    @Test
    public void roomIsFull(){
        bedroom1.addGuest(guest1);
        bedroom1.addGuest(guest2);
        assertEquals(true, bedroom1.isFull());
    }

    @Test
    public void cantAddMoreGuestsThanCapacity(){
        bedroom1.addGuest(guest1);
        bedroom1.addGuest(guest2);
        bedroom1.addGuest(guest3);
        assertEquals(true, bedroom1.isFull());
        assertEquals(2, bedroom1.getNoGuestsInRoom());
    }

    @Test
    public void canRemoveGuestsFromRoom(){
        bedroom1.addGuest(guest1);
        bedroom1.addGuest(guest2);
        bedroom1.checkOutGuests();
        assertEquals(0, bedroom1.getNoGuestsInRoom());
    }
}
