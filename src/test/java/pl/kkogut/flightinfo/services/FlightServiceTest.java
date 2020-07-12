package pl.kkogut.flightinfo.services;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.Assert.*;


import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {

    @Test
    void should_give_proper_new_status() {

        Assert.assertEquals(FlightService.getNewStatus("scheduled","30"),"delayed");
        Assert.assertEquals(FlightService.getNewStatus("scheduled","1min"),"delayed");
        Assert.assertEquals(FlightService.getNewStatus("scheduled","1h"),"delayed");
        Assert.assertEquals(FlightService.getNewStatus("active","1000"),"took off");
        Assert.assertEquals(FlightService.getNewStatus("cancelled",""),"cancelled");
        Assert.assertEquals(FlightService.getNewStatus("scheduled",null),"scheduled");
        Assert.assertEquals(FlightService.getNewStatus("active",null),"took off");
        Assert.assertEquals(FlightService.getNewStatus("cancelled",null),"cancelled");
    }
    @Test
    void should_not_give_any_new_status() {
        Assert.assertNull(FlightService.getNewStatus(null, "ABC"));
        Assert.assertNull(FlightService.getNewStatus(null,null));
    }
}