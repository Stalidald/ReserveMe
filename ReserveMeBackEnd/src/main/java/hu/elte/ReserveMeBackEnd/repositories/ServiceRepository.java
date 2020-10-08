package hu.elte.ReserveMeBackEnd.repositories;

import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceRepository extends CrudRepository<ServiceEntity, Long> {
    Optional<ServiceEntity> findByLabel(String label);

    Optional<ServiceEntity> findByType(String type);

    Boolean existsByType(String type);
}
