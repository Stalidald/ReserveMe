package hu.elte.ReserveMeBackEnd.repositories;

import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
    Optional<CustomerEntity> findByUserName(String userName);

    Optional<CustomerEntity> findByEmail(String email);

    Optional<CustomerEntity> findByName(String name);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}
