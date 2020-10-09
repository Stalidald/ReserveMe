package hu.elte.ReserveMeBackEnd.repositories;

import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import hu.elte.ReserveMeBackEnd.entities.ReservationEntity;
import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ReservationRepository extends CrudRepository<ReservationEntity, Long> {
    Optional<ReservationEntity> findByService(ServiceEntity service);

    Optional<ReservationEntity> findByFromAfter(Date from);

    Optional<ReservationEntity> findByFromBefore(Date from);

    Optional<ReservationEntity> findByToAfter(Date to);

    Optional<ReservationEntity> findByToBefore(Date to);
}
