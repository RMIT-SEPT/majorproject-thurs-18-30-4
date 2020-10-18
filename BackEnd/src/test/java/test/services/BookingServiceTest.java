package test.services;

import app.exception.BookingException;
import app.model.Booking;
import app.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    BookingService bookingService;
    @Test
    public void createBooking_throwsException_ifBookingHasId() {
        Booking booking = new Booking();

        booking.setId((new Long(100)));
        booking.setCustomerId(101L);
        booking.setWorkerId(102L);
        booking.setBusinessId(103L);

        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 9);
        cal1.set(Calendar.DATE, 24);
        cal1.set(Calendar.YEAR, 2013);
        cal1.set(Calendar.HOUR,13);
        cal1.set(Calendar.MINUTE,45);
        booking.setBooked_At(cal1.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.MONTH, 9);
        cal2.set(Calendar.DATE, 24);
        cal2.set(Calendar.YEAR, 2013);
        cal2.set(Calendar.HOUR,13);
        cal2.set(Calendar.MINUTE,45);
        booking.setBooked_Till(cal2.getTime());

        assertThrows(BookingException.class,
                ()->bookingService.createBooking(booking),
                "Test passed BookingException was thrown due to creating a booking that already had an id");
    }
    @Test
    public void findBookingById_foundBookingIsEqualToOriginal_ifBothHaveSameId() {
        Booking booking = new Booking();

        booking.setCustomerId(101L);
        booking.setWorkerId(102L);
        booking.setBusinessId(103L);

        Calendar cal1 = Calendar.getInstance();
        cal1.set(Calendar.MONTH, 9);
        cal1.set(Calendar.DATE, 24);
        cal1.set(Calendar.YEAR, 2013);
        cal1.set(Calendar.HOUR,13);
        cal1.set(Calendar.MINUTE,45);
        booking.setBooked_At(cal1.getTime());

        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.MONTH, 9);
        cal2.set(Calendar.DATE, 24);
        cal2.set(Calendar.YEAR, 2013);
        cal2.set(Calendar.HOUR,13);
        cal2.set(Calendar.MINUTE,45);
        booking.setBooked_Till(cal2.getTime());

        bookingService.createBooking(booking);

        Booking temp = bookingService.findBookingById(booking.getId());

        assertThat(temp.getId()).isEqualTo(booking.getId());
    }
}
