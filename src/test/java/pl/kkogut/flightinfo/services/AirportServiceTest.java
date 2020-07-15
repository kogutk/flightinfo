package pl.kkogut.flightinfo.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.City;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public
class AirportServiceTest {

    @Test
    void should_return_airport_from_airports() {
        //given
        Api api = new Api();
        CityService cityService = new CityService(api);
        AirportService airportService = new AirportService(api,cityService);

        City city = new City("Los Angeles", "LAX", "1", "1");

        Airport[] airports = new Airport[10];
        airports[0] = new Airport("LAX", "Los Angeles");

        String jsonTest = "{\"json\":\"test\"}";

        AirportService target = spy(airportService);

        Mockito.doReturn(jsonTest)
                .when(target)
                .getAirportJson("LAX");
        Mockito.doReturn(airports)
                .when(target)
                .getObjectFromJson(jsonTest, Airport[].class);
        Mockito.doReturn(city)
                .when(target)
                .getCity("Los Angeles");

        //when
        Airport ta = target.getAirport("LAX");

        //then
        Assert.assertEquals( airports[0], ta);

    }
    @Mock
    Api api;

    @Test
    void should_return_airport_from_iata_code(){
        //given
        String airportJson = "[{\"codeIataAirport\":\"LAX\",\"codeIataCity\":\"LAX\"}]";
        String cityJson = "[{\"codeIataCity\":\"LAX\"}]";
        Airport airport = new Airport("LAX");

        given(api.getAirportJson(anyString())).willReturn(airportJson);
        given(api.getCityJson(anyString())).willReturn(cityJson);

        //when
        CityService cs = new CityService(api);
        AirportService target = new AirportService(api,cs);

        //then
        Assert.assertEquals(airport, target.getAirport("LAX"));

        Assert.assertNotEquals(new Airport("WRO"), target.getAirport("LAX"));
        Assert.assertNotEquals(new Airport(null), target.getAirport("LAX"));

    }
}