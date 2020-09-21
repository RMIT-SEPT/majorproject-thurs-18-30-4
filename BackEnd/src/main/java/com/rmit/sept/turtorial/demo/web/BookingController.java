package com.rmit.sept.turtorial.demo.web;

import com.rmit.sept.turtorial.demo.model.Booking;
import com.rmit.sept.turtorial.demo.services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/bookings")
public class BookingController {
    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Booking> getBooking(@PathVariable() Long id) {
        Booking booking = bookingService.findBookingById(id);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Booking> addBooking(@RequestBody() @Valid Booking booking) {

        Booking addedBooking = bookingService.createBooking(booking);

        return new ResponseEntity<>(booking, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Booking> updateBooking(
            @PathVariable("id") long id, @RequestBody() @Valid Booking booking) {

        Booking updatedBooking = bookingService.updateBooking(id, booking);

        return new ResponseEntity<>(booking, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> cancelBooking(@PathVariable("id") long id) {

        boolean cancelled = bookingService.cancel(id);
        if (cancelled) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}