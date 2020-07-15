package pl.kkogut.flightinfo.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public
class FlightServiceTest {

    Api api = new Api();
    CityService cityService = new CityService(api);
    AirportService airportService = new AirportService(api, cityService);
    FlightService flightService = new FlightService(api, airportService);


    @Test
    void should_give_proper_new_status() {


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
        FlightService flightService = new FlightService(api, airportService);
        Assert.assertNull(flightService.getNewStatus(null, "ABC"));
        Assert.assertNull(flightService.getNewStatus(null,null));
    }
}