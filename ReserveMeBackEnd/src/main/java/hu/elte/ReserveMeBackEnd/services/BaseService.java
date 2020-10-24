package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.BaseEntity;
import hu.elte.ReserveMeBackEnd.services.exceptions.EntityCannotBeChangedException;
import hu.elte.ReserveMeBackEnd.services.validator.AbstractDataValidator;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Calendar;

public abstract class BaseService<Data extends BaseEntity> {

    protected AbstractDataValidator<Data, Data> validator;

    /**
     * @return all data
     */
    public abstract Iterable<Data> listAllData();

    /**
     * Load data based on id
     *
     * @param id
     * @return loaded data
     * @throws EntityNotFoundException
     */
    public abstract Data loadDataById(Long id) throws EntityNotFoundException;

    /**
     * save data
     *
     * @param data
     * @return
     */
    public abstract Data save(Data data);

    /**
     * Validates data
     *
     * @param data to validate
     * @return data validity
     */
    private boolean dataValid(Data data) {
        return validator.validate(listAllData(), data);
    }


    /**
     * @return current user
     */
    /*private String getCurrentUser() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }*/

    /**
     * Add data to database
     *
     * @param data to add
     * @return
     * @throws EntityExistsException
     */
    public Data addData(Data data) throws EntityExistsException {
        if (!dataValid(data)) {
            throw new EntityExistsException("SSS-1: Source data(" + data.getClass().toString() + ", " + data.getId() + ") exists)");
        }
        return save(data);
    }

    /**
     * Update data in database
     *
     * @param data to update
     * @return
     * @throws EntityExistsException
     */
    public Data updateData(Data data) throws EntityNotFoundException, EntityCannotBeChangedException {
        Data dataToUpdate = loadDataById(data.getId());
        if (!dataValid(data)) {
            throw new EntityCannotBeChangedException("SSS-1:Source data(" + data.getClass().toString() + ", " + data.getId() + ") cannot be changed!");
        }
        return save(data);
    }

    /**
     * Delete data from database
     *
     * @param data to delete
     * @return
     * @throws EntityExistsException
     */
    public Data deleteData(Data data) throws EntityNotFoundException {
        Data dataToDelete = loadDataById(data.getId());
        return save(dataToDelete);
    }
}
