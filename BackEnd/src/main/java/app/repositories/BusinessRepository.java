package app.repositories;

import app.model.Business;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BusinessRepository extends CrudRepository<Business, Long> {
    Optional<Business> findByName(Long id);
    @Override
    Iterable<Business> findAll();
}
