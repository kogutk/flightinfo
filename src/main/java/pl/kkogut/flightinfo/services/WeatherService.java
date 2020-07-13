package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.Weather;

public class WeatherService extends Service{

    WeatherService(Api api) {
        super(api);
    }

    public Weather getWeather(double latitude, double longitude){
        String result = api.getWeatherJson(latitude, longitude);
        Weather weather = getObjectFromJson(result, Weather.class);
        return weather;
    }
}
