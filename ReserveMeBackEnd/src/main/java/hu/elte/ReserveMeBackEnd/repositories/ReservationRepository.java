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

    Optional<ReservationEntity> findByBeginAfter(Date begin);

    Optional<ReservationEntity> findByBeginBefore(Date begin);

    Optional<ReservationEntity> findByEndAfter(Date end);

    Optional<ReservationEntity> findByEndBefore(Date end);
}
