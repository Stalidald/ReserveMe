package hu.elte.ReserveMeBackEnd.controllers;

import hu.elte.ReserveMeBackEnd.entities.ServiceProviderEntity;
import hu.elte.ReserveMeBackEnd.services.ServiceProviderService;
import hu.elte.ReserveMeBackEnd.services.exceptions.EmailNotFoundException;
import hu.elte.ReserveMeBackEnd.services.exceptions.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service-providers")
@CrossOrigin
public class ServiceProviderController extends BaseController{
    @Autowired
    ServiceProviderService serviceProviderService;

    /**
     * @return all stored serviceProviders
     */
    @GetMapping("")
    public ResponseEntity<Iterable<ServiceProviderEntity>> listAllServiceProvider() {
        return ResponseEntity.ok(serviceProviderService.listAllData());
    }

    /**
     * @return one serviceProvider, selected by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<ServiceProviderEntity> getServiceProviderById(@PathVariable long id) {
        return ResponseEntity.ok(serviceProviderService.loadDataById(id));
    }

    /**
     * @param newServiceProvider serviceProvider to update
     * @param id the id of serviceProvider
     * @return updated serviceProvider, or null if serviceProvider does not exits
     */
    @PutMapping("/{id}")
    public ResponseEntity<ServiceProviderEntity> putServiceProvider(@RequestBody ServiceProviderEntity newServiceProvider,@PathVariable long id) {
        return ResponseEntity.ok(serviceProviderService.updateServiceProvider(newServiceProvider,id));
    }

    /**
     * @return one serviceProvider, selected by e-mail
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<ServiceProviderEntity> getServiceProviderByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(serviceProviderService.loadServiceProviderByEmail(email));
        } catch (EmailNotFoundException e) {
            return createBadRequest(e);
        }
    }

    /**
     * @return one serviceProvider, selected by name
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<ServiceProviderEntity> getServiceProviderByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(serviceProviderService.loadServiceProviderByName(name));
        } catch (NameNotFoundException e) {
            return createBadRequest(e);
        }
    }

    /**
     * Delete a single serviceProvider selected by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteServiceProviderById(@PathVariable long id) {
        return ResponseEntity.ok(serviceProviderService.deleteData(serviceProviderService.loadDataById(id)));
    }
}