package hu.elte.ReserveMeBackEnd.repositories;

import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import hu.elte.ReserveMeBackEnd.entities.ServiceProviderEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ServiceProviderRepository extends CrudRepository<ServiceProviderEntity, Long> {
    Optional<ServiceProviderEntity> findByUserName(String userName);

    Optional<ServiceProviderEntity> findByEmail(String email);

    Optional<ServiceProviderEntity> findByName(String name);

    Iterable<ServiceProviderEntity> findAllByServices(ServiceEntity service);

    Boolean existsByUserName(String userName);

    Boolean existsByEmail(String email);
}
