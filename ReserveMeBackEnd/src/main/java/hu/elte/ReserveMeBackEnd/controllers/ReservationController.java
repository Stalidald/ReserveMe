package hu.elte.ReserveMeBackEnd.controllers;

import hu.elte.ReserveMeBackEnd.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.elte.ReserveMeBackEnd.entities.ReservationEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/reservations")
public class ReservationController extends BaseController{
    @Autowired
    ReservationService reservationService;

    /**
     * @return all stored reservations
     */
    @GetMapping("")
    public ResponseEntity<Iterable<ReservationEntity>> listAllReservation() {
        return ResponseEntity.ok(reservationService.listAllData());
    }

    /**
     * @return one reservation, selected by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ReservationEntity> getReservationById(@PathVariable long id) {
        return ResponseEntity.ok(reservationService.loadDataById(id));
    }

    /**
     * @param newReservation reservation to update
     * @param id the id of reservation
     * @return updated reservation, or null if reservation does not exits
     */
    @PutMapping("/{id}")
    public ResponseEntity<ReservationEntity> putReservation(@RequestBody ReservationEntity newReservation,@PathVariable long id) {
        return ResponseEntity.ok(reservationService.updateReservation(newReservation,id));
    }

    /**
     * Delete a single reservation selected by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteReservationById(@PathVariable long id) {
        return ResponseEntity.ok(reservationService.deleteData(reservationService.loadDataById(id)));
    }
}