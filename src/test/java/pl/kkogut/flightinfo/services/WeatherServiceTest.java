package pl.kkogut.flightinfo.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.kkogut.flightinfo.models.Weather;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public
class WeatherServiceTest {

    @Mock
    Api api;

    @Test
    void should_return_proper_weather_object() {
        //given
        String weatherJson = "{\"weather\": [{\"description\": \"scattered clouds\",\"icon\": \"03d\"}],\"main\": {\"temp\": 34.85}}";
        Weather.WeatherDesc wd = new Weather.WeatherDesc("scattered clouds","03d");
        Weather.WeatherDesc[] wds = new Weather.WeatherDesc[1];
        wds[0]=wd;
        Weather.Main wm = new Weather.Main(34.85d);
        Weather w = new Weather(wds,wm);

        given(api.getWeatherJson(anyDouble(), anyDouble())).willReturn(weatherJson);
        //when
        WeatherService target = new WeatherService(api);
        Weather targetWeather = target.getWeather(1,1);
        //then
        Assert.assertEquals(w, targetWeather);

    }
}