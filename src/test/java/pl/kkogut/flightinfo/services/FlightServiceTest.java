package pl.kkogut.flightinfo.services;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkogut.flightinfo.models.City;


import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class FlightServiceTest {

    @Mock
    Api api;
    @Mock
    CityService cityService;
    @Test
    void should_give_proper_new_status() {
        FlightService flightService = new FlightService(api, cityService);

        Assert.assertEquals(flightService.getNewStatus("scheduled","30"),"delayed");
        Assert.assertEquals(flightService.getNewStatus("scheduled","1min"),"delayed");
        Assert.assertEquals(flightService.getNewStatus("scheduled","1h"),"delayed");
        Assert.assertEquals(flightService.getNewStatus("active","1000"),"took off");
        Assert.assertEquals(flightService.getNewStatus("cancelled",""),"cancelled");
        Assert.assertEquals(flightService.getNewStatus("scheduled",null),"scheduled");
        Assert.assertEquals(flightService.getNewStatus("active",null),"took off");
        Assert.assertEquals(flightService.getNewStatus("cancelled",null),"cancelled");
    }
    @Test
    void should_not_give_any_new_status() {
        FlightService flightService = new FlightService(api, cityService);
        Assert.assertNull(flightService.getNewStatus(null, "ABC"));
        Assert.assertNull(flightService.getNewStatus(null,null));
    }
}