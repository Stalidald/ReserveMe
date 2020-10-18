package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import hu.elte.ReserveMeBackEnd.repositories.CustomerRepository;
import hu.elte.ReserveMeBackEnd.services.exceptions.EmailNotFoundException;
import hu.elte.ReserveMeBackEnd.services.exceptions.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@SessionScope
public class CustomerService extends BaseService<CustomerEntity>{
    @Autowired
    CustomerRepository customerRepository;

    /**
     * Constructor of CustomerService instance based on customer repository
     * @param customerRepository
     */
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    /**
     * @return all data from customer repository
     */
    @Override
    public Iterable<CustomerEntity> listAllData() {
        return customerRepository.findAll();
    }

    /**
     * Loads data by ID
     * @param id
     * @return loaded data
     * @throws EntityNotFoundException if data by ID does not exist
     */
    @Override
    public CustomerEntity loadDataById(Long id) throws EntityNotFoundException {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " not found!"));
    }

    /**
     * Saves customer entity to repository
     * @param customerEntity to save
     * @return
     */
    @Override
    public CustomerEntity save(CustomerEntity customerEntity) {
        return customerRepository.save(customerEntity);
    }

    /**
     * Updates customer
     * @param newCustomer customer to update
     * @param id the if of the customer
     * @return updated customer, or null, if customer does not exist
     */
    public CustomerEntity updateCustomer(CustomerEntity newCustomer, Long id) {
        Optional<CustomerEntity> oldCustomer = customerRepository.findById(id);
        if(oldCustomer.isPresent()){
            newCustomer.setId(id);
            CustomerEntity newSavedCustomer = customerRepository.save(newCustomer);
            return newSavedCustomer;
        }else{
            return null;
        }
    }

    /**
     * Loads customer by email
     * @param email
     * @return
     * @throws EmailNotFoundException
     */
    public CustomerEntity loadCustomerByEmail(String email) throws EmailNotFoundException {
        return customerRepository
                .findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(email + " not found!"));
    }

    /**
     * Loads customer by name
     * @param name
     * @return
     * @throws NameNotFoundException
     */
    public CustomerEntity loadCustomerByName(String name) throws NameNotFoundException {
        return customerRepository
                .findByName(name)
                .orElseThrow(() -> new NameNotFoundException(name + " not found!"));
    }
}
