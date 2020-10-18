package app.repositories;

import app.model.Booking;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface BookingRepository extends CrudRepository<Booking, Long> {

    @Override
    Iterable<Booking> findAll();

    Optional<Booking> findBookingById(Long id);

}
