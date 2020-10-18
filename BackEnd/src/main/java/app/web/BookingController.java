package app.web;

import app.model.Booking;
import app.rest.response.MessageResponse;
import app.services.BookingService;
import com.rmit.sept.turtorial.demo.rest.request.BookingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/bookings")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable() Long id) {
        Booking booking = bookingService.findBookingById(id);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping()
    public ResponseEntity<Iterable<Booking>> getAllBookings() {
        Iterable<Booking> bookings = bookingService.findAllBookings();

        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping()
    public ResponseEntity<?> addBooking(@RequestBody @Valid BookingRequest bookingRequest) {
        Booking booking = new Booking(100L, bookingRequest.getBusinessId(), bookingRequest.getCustomerId(),
                bookingRequest.getWorkerId(), bookingRequest.getBooked_At(), bookingRequest.getBooked_Till());

        bookingService.createBooking(booking);

        return ResponseEntity.ok(new MessageResponse("Booking created successfully!"));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable("id") long id, @RequestBody() @Valid Booking booking) {

        Booking updatedBooking = bookingService.updateBooking(id, booking);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> cancelBooking(@PathVariable("id") long id) {

        boolean cancelled = bookingService.cancel(id);
        if (cancelled) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
