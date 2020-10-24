package hu.elte.ReserveMeBackEnd.controllers;

import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import hu.elte.ReserveMeBackEnd.services.CustomerService;
import hu.elte.ReserveMeBackEnd.services.exceptions.EmailNotFoundException;
import hu.elte.ReserveMeBackEnd.services.exceptions.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customers")
@CrossOrigin
public class CustomerController extends BaseController{
    @Autowired
    CustomerService customerService;

    /**
     * @return all stored customers
     */
    @GetMapping("")
    public ResponseEntity<Iterable<CustomerEntity>> listAllCustomer() {
        return ResponseEntity.ok(customerService.listAllData());
    }

    /**
     * @return one customer, selected by ID
     */
    @GetMapping("/{id}")
    public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable long id) {
        return ResponseEntity.ok(customerService.loadDataById(id));
    }

    /**
     * @param newCustomer customer to update
     * @param id the id of customer
     * @return updated customer, or null if customer does not exits
     */
    @PutMapping("/{id}")
    public ResponseEntity<CustomerEntity> putCustomer(@RequestBody CustomerEntity newCustomer,@PathVariable long id) {
        return ResponseEntity.ok(customerService.updateCustomer(newCustomer,id));
    }

    /**
     * @return one customer, selected by e-mail
     */
    @GetMapping("/email/{email}")
    public ResponseEntity<CustomerEntity> getCustomerByEmail(@PathVariable String email) {
        try {
            return ResponseEntity.ok(customerService.loadCustomerByEmail(email));
        } catch (EmailNotFoundException e) {
            return createBadRequest(e);
        }
    }

    /**
     * @return one customer, selected by name
     */
    @GetMapping("/name/{name}")
    public ResponseEntity<CustomerEntity> getCustomerByName(@PathVariable String name) {
        try {
            return ResponseEntity.ok(customerService.loadCustomerByName(name));
        } catch (NameNotFoundException e) {
            return createBadRequest(e);
        }
    }

    /**
     * Delete a single customer selected by ID
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCustomerById(@PathVariable long id) {
        return ResponseEntity.ok(customerService.deleteData(customerService.loadDataById(id)));
    }
}
