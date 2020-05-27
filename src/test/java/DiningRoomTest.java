import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DiningRoomTest {

    private Guest guest1, guest2;
    private DiningRoom diningRoom1;

    @Before
    public void before(){
        guest1 = new Guest("Borromir");
        guest2 = new Guest("Legolas");
//        ArrayList<Guest> guests = new ArrayList<Guest>() {
//            {
//                add(guest1);
//                add(guest2);
//            }
//        };
        diningRoom1 = new DiningRoom("Rohan");
    }

    @Test
    public void hasName(){
        assertEquals("Rohan", diningRoom1.getName());
    }

    @Test
    public void hasNoGuestsAtStart(){
        assertEquals(0, diningRoom1.getNoOfGuests());
    }
}
