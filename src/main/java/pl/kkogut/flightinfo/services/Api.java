package pl.kkogut.flightinfo.services;

import org.springframework.web.client.RestTemplate;

public class Api {
    private final static String FLIGHT_API_KEY = "1044c9-8e7a15";
    private final static String WEATHER_API_KEY = "8c6cdf6e368dee075ea9f5716bbc54eb";

    public String getAirportJson(String iataCode) {
        final String uri ="http://aviation-edge.com/v2/public/airportDatabase?key=" + FLIGHT_API_KEY + "&codeIataAirport=" + iataCode;
        return getJson(uri);
    }

    public String getCityJson(String codeIataCity) {
        final String uri ="http://aviation-edge.com/v2/public/cityDatabase?key=" + FLIGHT_API_KEY + "&codeIataCity=" + codeIataCity;
        return getJson(uri);
    }

    public String getFlightsJson(String iataCode) {
        final String uri = "http://aviation-edge.com/v2/public/timetable?key=" + FLIGHT_API_KEY + "&iataCode=" + iataCode + "&type=departure";
        return getJson(uri);
    }

    public String getWeatherJson(double latitude, double longitude) {
        final String uri ="https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=" + WEATHER_API_KEY +"&units=metric";
        return getJson(uri);
    }
    private String getJson(String uri){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri,String.class);
    }
}
