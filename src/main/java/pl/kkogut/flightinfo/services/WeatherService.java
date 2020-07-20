package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.Weather;

public class WeatherService extends Service{

    WeatherService(Api api) {
        super(api);
    }
    /**
     * Give weather detailed information.
     * <p>Serves Weather object for a given location coordinates (latitude and longitude).</p>
     * @param latitude Latitude of the location.
     * @param longitude Longitude of the location.
     * @return City object.
     */
    public Weather getWeather(double latitude, double longitude){
        String result = api.getWeatherJson(latitude, longitude);
        Weather weather = getObjectFromJson(result, Weather.class);
        return weather;
    }
}
