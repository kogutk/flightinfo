package pl.kkogut.flightinfo.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkogut.flightinfo.models.City;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public
class CityServiceTest {

    @Mock
    Api api;

    @Test
    void should_return_proper_city() {
        //given
        String cityJson = "[{\"codeIataCity\":\"LAX\",\"nameCity\":\"Los Angeles\"}]";
        City city = new City("Los Angeles", "LAX", "1", "1");

        City otherCity =new City("Wroclaw", "WRO", "1", "1");
        given(api.getCityJson(anyString())).willReturn(cityJson);
        //when
        CityService target = new CityService(api);
        //then
        Assert.assertEquals(city, target.getCity("LAX"));

        Assert.assertNotEquals(otherCity, target.getCity("LAX"));
    }
    @Test
    void should_return_empty_city_from_empty_json() {
        //given
        String cityJson = "[{}]";

        given(api.getCityJson(anyString())).willReturn(cityJson);
        //when
        CityService target = new CityService(api);
        City targetCity = target.getCity("LAX");
        //then

        Assert.assertNull(targetCity.getCodeIataCity());
        Assert.assertNull(targetCity.getNameCity());
        Assert.assertNull(targetCity.getLatitudeCity());
        Assert.assertNull(targetCity.getLongitudeCity());

    }
}