package hu.elte.ReserveMeBackEnd.services;


import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import hu.elte.ReserveMeBackEnd.services.CustomerService;


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


//@RunWith(MockitoJUnitRunner.class)
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    @MockBean
    private CustomerService customerService;

    private List<CustomerEntity> customerEntityList;

    @Before
    public void setup() {
        customerEntityList = Arrays.asList(
                new CustomerEntity("Leonardo"),
                new CustomerEntity("Test"),
                new CustomerEntity("Second"));
    }

    @Test
    public void listAllData() {
        customerService = Mockito.mock(CustomerService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(customerService.listAllData()).thenReturn(customerEntityList);
        assertEquals(customerService.listAllData(), customerEntityList);
    }

    @Test
    public void loadDataById() {
        customerEntityList = Arrays.asList(
                new CustomerEntity("Leonardo"),
                new CustomerEntity("Test"),
                new CustomerEntity("Second"));

        customerService = Mockito.mock(CustomerService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(customerService.loadDataById(1L)).thenReturn(customerEntityList.get(0));
        assertEquals(customerService.loadDataById(1L), customerEntityList.get(0));
    }

    @Test
    public void loadCustomerByName() throws NameNotFoundException {
        customerEntityList = Arrays.asList(
                new CustomerEntity("Leonardo"),
                new CustomerEntity("Test"),
                new CustomerEntity("Second"));

        customerService = Mockito.mock(CustomerService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(customerService.loadCustomerByName("Test")).thenReturn(customerEntityList.get(1));
        assertEquals(customerService.loadCustomerByName("Test"), customerEntityList.get(1));
    }
}
