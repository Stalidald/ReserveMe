package hu.elte.ReserveMeBackEnd.controllers;

import hu.elte.ReserveMeBackEnd.services.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/services")
public class ServiceController extends BaseController{
    @Autowired
    ServiceService serviceService;

    /**
     * @return all stored services
     */
    @GetMapping("")
    public ResponseEntity<Iterable<ServiceEntity>> listAllService() {
        return ResponseEntity.ok(serviceService.listAllData());
    }

    /**
     * @return one service, selected by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceEntity> getServiceById(@PathVariable long id) {
        return ResponseEntity.ok(serviceService.loadDataById(id));
    }

    /**
     * @param newService service to update
     * @param id the id of service
     * @return updated service, or null if service does not exits
     */
    @PutMapping("/{id}")
    public ResponseEntity<ServiceEntity> putService(@RequestBody ServiceEntity newService,@PathVariable long id) {
        return ResponseEntity.ok(serviceService.updateService(newService,id));
    }

    /**
     * Delete a single service selected by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceById(@PathVariable long id) {
        return ResponseEntity.ok(serviceService.deleteData(serviceService.loadDataById(id)));
    }
}