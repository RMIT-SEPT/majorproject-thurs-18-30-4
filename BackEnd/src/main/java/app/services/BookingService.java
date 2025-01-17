package app.services;

import app.exception.BookingException;
import app.repositories.BookingRepository;
import app.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        booking.setId(booking.getId());
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

    // instantiates a Booking object with the booking parameter id
    // then checks if it is still active
    // if not active, then throw an exception
    // set the booking with a new id, set it to active and save it to the repository
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

    @Transactional
    public Iterable<Booking> findAllBookings() {
        return bookingRepository.findAll();
    }
}
