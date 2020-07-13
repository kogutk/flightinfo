package pl.kkogut.flightinfo.services;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import pl.kkogut.flightinfo.models.Airport;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

class AirportServiceTest {

//    @Mock
//    AirportService target;
//    @Mock
//    Api api;
//    @Rule MockitoRule mockitoRule = MockitoJUnit.rule();

    @Test
    void should_return_airport_from_airports() {

        Airport[] airports = new Airport[1];
        airports[0] = new Airport("WAW");

        Api api = mock(Api.class);
        AirportService target = mock(AirportService.class);

        
        given(api.getAirportJson("")).willReturn("");
        given(target.getObjectFromJson("", Airport[].class)).willReturn(airports);

        AirportService as = new AirportService();

        //then
        Assert.assertEquals( new Airport("WAW"),as.getAirport("") );

    }
}