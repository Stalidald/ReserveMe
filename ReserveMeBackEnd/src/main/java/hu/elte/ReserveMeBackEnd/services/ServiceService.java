package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import hu.elte.ReserveMeBackEnd.repositories.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
@SessionScope
public class ServiceService extends BaseService<ServiceEntity>{
    @Autowired
    ServiceRepository serviceRepository;

    /**
     * Constructor of ServiceService instance based on service repository
     * @param serviceRepository
     */
    @Autowired
    public ServiceService(ServiceRepository serviceRepository) {
        this.serviceRepository = serviceRepository;
    }

    /**
     * @return all data from service repository
     */
    @Override
    public Iterable<ServiceEntity> listAllData() {
        return serviceRepository.findAll();
    }

    /**
     * Loads data by ID
     * @param id
     * @return loaded data
     * @throws EntityNotFoundException if data by ID does not exist
     */
    @Override
    public ServiceEntity loadDataById(Long id) throws EntityNotFoundException {
        return serviceRepository
                .findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id + " not found!"));
    }

    /**
     * Saves service entity to repository
     * @param serviceEntity to save
     * @return
     */
    @Override
    public ServiceEntity save(ServiceEntity serviceEntity) {
        return serviceRepository.save(serviceEntity);
    }

    /**
     * Updates service
     * @param newService service to update
     * @param id the if of the service
     * @return updated service, or null, if service does not exist
     */
    public ServiceEntity updateService(ServiceEntity newService, Long id) {
        Optional<ServiceEntity> oldService = serviceRepository.findById(id);
        if(oldService.isPresent()){
            newService.setId(id);
            ServiceEntity newSavedService = serviceRepository.save(newService);
            return newSavedService;
        }else{
            return null;
        }
    }
}
