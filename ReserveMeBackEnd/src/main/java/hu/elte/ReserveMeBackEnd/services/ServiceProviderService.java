package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.ServiceProviderEntity;
import hu.elte.ReserveMeBackEnd.repositories.ServiceProviderRepository;
import hu.elte.ReserveMeBackEnd.services.exceptions.EmailNotFoundException;
import hu.elte.ReserveMeBackEnd.services.exceptions.NameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@SessionScope
public class ServiceProviderService extends BaseService<ServiceProviderEntity>{
    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    /**
     * Constructor of ServiceProviderService instance based on serviceProvider repository
     * @param serviceProviderRepository
     */
    @Autowired
    public ServiceProviderService(ServiceProviderRepository serviceProviderRepository) {
        this.serviceProviderRepository = serviceProviderRepository;
    }

    /**
     * @return all data from serviceProvider repository
     */
    @Override
    public Iterable<ServiceProviderEntity> listAllData() {
        return serviceProviderRepository.findAll();
    }

    /**
     * Loads data by ID
     * @param id
     * @return loaded data
     * @throws EntityNotFoundException if data by ID does not exist
     */
    @Override
    public ServiceProviderEntity loadDataById(Long id) throws EntityNotFoundException {
        return serviceProviderRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " not found!"));
    }

    /**
     * Saves serviceProvider entity to repository
     * @param serviceProviderEntity to save
     * @return
     */
    @Override
    public ServiceProviderEntity save(ServiceProviderEntity serviceProviderEntity) {
        return serviceProviderRepository.save(serviceProviderEntity);
    }

    /**
     * Updates serviceProvider
     * @param newServiceProvider serviceProvider to update
     * @param id the if of the serviceProvider
     * @return updated serviceProvider, or null, if serviceProvider does not exist
     */
    public ServiceProviderEntity updateServiceProvider(ServiceProviderEntity newServiceProvider, Long id) {
        Optional<ServiceProviderEntity> oldServiceProvider = serviceProviderRepository.findById(id);
        if(oldServiceProvider.isPresent()){
            newServiceProvider.setId(id);
            ServiceProviderEntity newSavedServiceProvider = serviceProviderRepository.save(newServiceProvider);
            return newSavedServiceProvider;
        }else{
            return null;
        }
    }

    /**
     * Loads serviceProvider by email
     * @param email
     * @return
     * @throws EmailNotFoundException
     */
    public ServiceProviderEntity loadServiceProviderByEmail(String email) throws EmailNotFoundException {
        return serviceProviderRepository
                .findByEmail(email)
                .orElseThrow(() -> new EmailNotFoundException(email + " not found!"));
    }

    /**
     * Loads serviceProvider by name
     * @param name
     * @return
     * @throws NameNotFoundException
     */
    public ServiceProviderEntity loadServiceProviderByName(String name) throws NameNotFoundException {
        return serviceProviderRepository
                .findByName(name)
                .orElseThrow(() -> new NameNotFoundException(name + " not found!"));
    }
}
