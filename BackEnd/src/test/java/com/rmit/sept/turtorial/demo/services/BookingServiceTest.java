package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.exception.BookingException;
import com.rmit.sept.turtorial.demo.model.Booking;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class BookingServiceTest {

    @Autowired
    BookingService bookingService;
    @Test
    public void createBooking_throwsException_ifBookingHasId() {
        Booking booking = new Booking();

        booking.setId((new Long(100)));

        assertThrows(BookingException.class,
                ()->bookingService.createBooking(booking),
                "Test passed, as BookingException was thrown due to creating a booking that already had an id");
    }
}
