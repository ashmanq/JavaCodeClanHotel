import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookingTest {

    private Booking booking1, booking2;
    private Bedroom bedroom1, bedroom2;

    @Before
    public void before(){

        bedroom1 = new Bedroom(1, 2, "Double", 20.00);
        bedroom2 = new Bedroom(2, 1, "Single", 10.00);
        booking1 = new Booking(bedroom1, 2);
        booking2 = new Booking(bedroom2, 3);

    }

    @Test
    public void hasBedroom(){
        assertEquals(bedroom1, booking1.getBedroom());
    }

    @Test
    public void hasNoOfNights(){
        assertEquals(2, booking1.getNoOfNights());
    }

    @Test
    public void canGetBookingTotal(){
        assertEquals(40.00, booking1.getTotalBill(), 0.01);
    }

}
