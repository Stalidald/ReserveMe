package hu.elte.ReserveMeBackEnd.services;

import hu.elte.ReserveMeBackEnd.entities.CustomerEntity;
import hu.elte.ReserveMeBackEnd.entities.ReservationEntity;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class ReservationServiceTest {

    @MockBean
    private ReservationService reservationService;

    private List<ReservationEntity> reservationEntities;

    @Before
    public void setup() {
        reservationEntities = Arrays.asList(
                new ReservationEntity(new Date(2020, Calendar.OCTOBER,30, 10,50), new Date(2020, Calendar.OCTOBER,30, 11,50)),
                new ReservationEntity(new Date(2020, Calendar.NOVEMBER,10, 22,50), new Date(2020, Calendar.NOVEMBER,10, 23,50)),
                new ReservationEntity(new Date(2020, Calendar.DECEMBER,30, 10,50), new Date(2020, Calendar.DECEMBER,30, 11,50)));
    }

    @Test
    void listAllData() {
        reservationService = Mockito.mock(ReservationService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(reservationService.listAllData()).thenReturn(reservationEntities);
        assertEquals(reservationService.listAllData(), reservationEntities);
    }

    @Test
    void loadDataById() {
        reservationEntities = Arrays.asList(
                new ReservationEntity(new Date(2020, Calendar.OCTOBER,30, 10,50), new Date(2020, Calendar.OCTOBER,30, 11,50)),
                new ReservationEntity(new Date(2020, Calendar.NOVEMBER,10, 22,50), new Date(2020, Calendar.NOVEMBER,10, 23,50)),
                new ReservationEntity(new Date(2020, Calendar.DECEMBER,30, 10,50), new Date(2020, Calendar.DECEMBER,30, 11,50)));
        reservationService = Mockito.mock(ReservationService.class, Mockito.RETURNS_DEEP_STUBS);
        Mockito.when(reservationService.loadDataById(1L)).thenReturn(reservationEntities.get(0));
        assertEquals(reservationService.loadDataById(1L), reservationEntities.get(0));
    }


}
