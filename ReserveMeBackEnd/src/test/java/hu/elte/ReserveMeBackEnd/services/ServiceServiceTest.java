package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.ServiceEntity;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class ServiceServiceTest {

    @MockBean
    private ServiceService serviceService;

    private List<ServiceEntity> serviceEntities;

    @Before
    public void setup() {
        serviceEntities = Arrays.asList(
                new ServiceEntity("Autó szerviz", "szerviz", 1000),
                new ServiceEntity("Thai masszazs", "masszazs", 1000),
                new ServiceEntity("Harry Potter szabaduloszoba", "szabaduloszoba", 1000));
    }

    @Test
    void listAllData() {
        serviceService = Mockito.mock(ServiceService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(serviceService.listAllData()).thenReturn(serviceEntities);
        assertEquals(serviceService.listAllData(), serviceEntities);
    }

    @Test
    void loadDataById() {
        serviceEntities = Arrays.asList(
                new ServiceEntity("Autó szerviz", "szerviz", 1000),
                new ServiceEntity("Thai masszazs", "masszazs", 1000),
                new ServiceEntity("Harry Potter szabaduloszoba", "szabaduloszoba", 1000));

        serviceService = Mockito.mock(ServiceService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(serviceService.loadDataById(1L)).thenReturn(serviceEntities.get(0));
        assertEquals(serviceService.loadDataById(1L), serviceEntities.get(0));
    }

}
