package com.rmit.sept.turtorial.demo.services;

import app.exception.BookingException;
import app.model.Booking;
import app.services.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

        assertThrows(BookingException.class,
                ()->bookingService.createBooking(booking),
                "Test passed BookingException was thrown due to creating a booking that already had an id");
    }
    @Test
    public void findBookingById_foundBookingIsEqualToOriginal_ifBothHaveSameId() {
        Booking booking = new Booking();
        bookingService.createBooking(booking);

        Booking temp = bookingService.findBookingById(booking.getId());

        assertThat(temp.getId()).isEqualTo(booking.getId());
    }
}
