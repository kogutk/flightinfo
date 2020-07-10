package pl.kkogut.flightinfo.services;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import pl.kkogut.flightinfo.models.Weather;

public class WeatherService {
    public static Weather getWeather(double latitude, double longitude){
        final String uri ="https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=8c6cdf6e368dee075ea9f5716bbc54eb&units=metric";

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri,String.class);
        Weather weather = new Gson().fromJson(result, Weather.class);

        return weather;
    }
}
