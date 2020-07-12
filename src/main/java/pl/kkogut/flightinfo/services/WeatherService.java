package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.Weather;

public class WeatherService extends Service{
    public static Weather getWeather(double latitude, double longitude){
        String result = Api.getWeatherJson(latitude, longitude);
        Weather weather = getObjectFromJson(result, Weather.class);
        return weather;
    }
}
