package hu.elte.ReserveMeBackEnd.repositories;

import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import hu.elte.ReserveMeBackEnd.entities.ServiceProviderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceProviderRepository extends CrudRepository<ServiceProviderEntity, Long> {
    Optional<ServiceProviderEntity> findByUsername(String username);

    Optional<ServiceProviderEntity> findByEmail(String email);

    Iterable<ServiceProviderEntity> findAllByServices(ServiceEntity service);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}
