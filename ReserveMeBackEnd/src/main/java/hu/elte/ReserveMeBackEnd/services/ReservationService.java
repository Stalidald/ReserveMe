package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.ReservationEntity;
import hu.elte.ReserveMeBackEnd.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@SessionScope
public class ReservationService extends BaseService<ReservationEntity>{
    @Autowired
    ReservationRepository reservationRepository;

    /**
     * Constructor of ReservationService instance based on reservation repository
     * @param reservationRepository
     */
    @Autowired
    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    /**
     * @return all data from reservation repository
     */
    @Override
    public Iterable<ReservationEntity> listAllData() {
        return reservationRepository.findAll();
    }

    /**
     * Loads data by ID
     * @param id
     * @return loaded data
     * @throws EntityNotFoundException if data by ID does not exist
     */
    @Override
    public ReservationEntity loadDataById(Long id) throws EntityNotFoundException {
        return reservationRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " not found!"));
    }

    /**
     * Saves reservation entity to repository
     * @param reservationEntity to save
     * @return
     */
    @Override
    public ReservationEntity save(ReservationEntity reservationEntity) {
        return reservationRepository.save(reservationEntity);
    }

    /**
     * Updates reservation
     * @param newReservation reservation to update
     * @param id the if of the reservation
     * @return updated reservation, or null, if reservation does not exist
     */
    public ReservationEntity updateReservation(ReservationEntity newReservation, Long id) {
        Optional<ReservationEntity> oldReservation = reservationRepository.findById(id);
        if(oldReservation.isPresent()){
            newReservation.setId(id);
            ReservationEntity newSavedReservation = reservationRepository.save(newReservation);
            return newSavedReservation;
        }else{
            return null;
        }
    }
}
