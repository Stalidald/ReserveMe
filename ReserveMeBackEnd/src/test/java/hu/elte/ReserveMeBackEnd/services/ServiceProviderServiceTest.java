package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.ServiceProviderEntity;
import hu.elte.ReserveMeBackEnd.services.exceptions.EmailNotFoundException;
import hu.elte.ReserveMeBackEnd.services.exceptions.NameNotFoundException;
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
public class ServiceProviderServiceTest {


    @MockBean
    private ServiceProviderService serviceProviderService;

    private List<ServiceProviderEntity> serviceProviderEntityList;

    @Before
    public void setup() {
        serviceProviderEntityList = Arrays.asList(
                new ServiceProviderEntity("Feri", "stalidald@gmail.com", "alma123"),
                new ServiceProviderEntity("Tomi", "tomi19990314@gmail.com", "asd1234"),
                new ServiceProviderEntity("Adam", "adam@gmail.com", "hahahah10"));
    }

    @Test
    public void test_ListAllData() {
        serviceProviderService = Mockito.mock(ServiceProviderService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(serviceProviderService.listAllData()).thenReturn(serviceProviderEntityList);
        assertEquals(serviceProviderService.listAllData(), serviceProviderEntityList);
    }

    @Test
    public void test_loadDataById() {
        serviceProviderEntityList = Arrays.asList(
                new ServiceProviderEntity("Feri", "stalidald@gmail.com", "alma123"),
                new ServiceProviderEntity("Tomi", "tomi19990314@gmail.com", "asd1234"),
                new ServiceProviderEntity("Adam", "adam@gmail.com", "hahahah10"));

        serviceProviderService = Mockito.mock(ServiceProviderService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(serviceProviderService.loadDataById(1L)).thenReturn(serviceProviderEntityList.get(0));
        assertEquals(serviceProviderService.loadDataById(1L), serviceProviderEntityList.get(0));
    }

    @Test
    public void test_loadUserByEmail() throws EmailNotFoundException {
        serviceProviderEntityList = Arrays.asList(
                new ServiceProviderEntity("Feri", "stalidald@gmail.com", "alma123"),
                new ServiceProviderEntity("Tomi", "tomi19990314@gmail.com", "asd1234"),
                new ServiceProviderEntity("Adam", "adam@gmail.com", "hahahah10"));

        serviceProviderService = Mockito.mock(ServiceProviderService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(serviceProviderService.loadServiceProviderByEmail("tomi19990314@gmail.com")).thenReturn(serviceProviderEntityList.get(1));
        assertEquals(serviceProviderService.loadServiceProviderByEmail("tomi19990314@gmail.com"), serviceProviderEntityList.get(1));
    }

    @Test
    public void test_loadUserByname() throws NameNotFoundException {
        serviceProviderEntityList = Arrays.asList(
                new ServiceProviderEntity("Feri", "stalidald@gmail.com", "alma123"),
                new ServiceProviderEntity("Tomi", "tomi19990314@gmail.com", "asd1234"),
                new ServiceProviderEntity("Adam", "adam@gmail.com", "hahahah10"));

        serviceProviderService = Mockito.mock(ServiceProviderService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(serviceProviderService.loadServiceProviderByName("Feri")).thenReturn(serviceProviderEntityList.get(0));
        assertEquals(serviceProviderService.loadServiceProviderByName("Feri"), serviceProviderEntityList.get(0));
    }

}
