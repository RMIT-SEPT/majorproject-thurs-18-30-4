package com.rmit.sept.turtorial.demo.services;

import com.rmit.sept.turtorial.demo.exception.BookingException;
import com.rmit.sept.turtorial.demo.model.Booking;
import com.rmit.sept.turtorial.demo.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.CannotAcquireLockException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    // Method to create a new booking. Throws an exception if the booking has an id. Otherwise returns the saved booking.
    @Transactional()
    public Booking createBooking(Booking booking) {
        if (booking.getId() != null) {
            throw new BookingException(String.format("New booking must not have an id"));
        }
        return bookingRepository.save(booking);
    }

    // Method to cancel a booking. Returns true if the booking is cancelled.
    @Transactional
    public boolean cancel(Long id) {
        Booking booking = findBookingById(id);
        booking.setIsActive(false);
        save(booking);
        return !booking.isActive;
    }

    public void save(Booking booking) {
        bookingRepository.save(booking);
    }

    // Method to find a booking with id parameter. Throws an exception if the booking is not found. Otherwise returns the booking with specified id.
    @Transactional
    public Booking findBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findBookingById(id);
        if(!booking.isPresent()) {
            throw new BookingException(String.format("Booking was not found for id = %d", id));
        }
        return booking.get();
    }

    @Transactional
    public Booking updateBooking(long id, Booking booking) {

        Booking persistedBooking = findBookingById(booking.getId());

        if (!persistedBooking.getIsActive()) {
            String message = String.format("Booking with id=%d is cancelled", booking.getId());
            throw new BookingException(message);
        }
        booking.setId(id);
        booking.setIsActive(persistedBooking.getIsActive());
        return bookingRepository.save(booking);
    }

}
