package pl.kkogut.flightinfo.services;

import org.springframework.web.client.RestTemplate;

public class Api {
    private final static String FLIGHT_API_KEY = "83823f-24ddf2";
    private final static String WEATHER_API_KEY = "8c6cdf6e368dee075ea9f5716bbc54eb";

    /**
     * Give Airport details in json data.
     * @param iataCode Code of the airport from IATA system.
     * @return Json with airport information.
     */
    public String getAirportJson(String iataCode) {
        final String uri ="http://aviation-edge.com/v2/public/airportDatabase?key=" + FLIGHT_API_KEY + "&codeIataAirport=" + iataCode;
        return getJson(uri);
    }
    /**
     * Give City details in json data.
     * @param codeIataCity Code of the city from IATA system.
     * @return Json with city information.
     */
    public String getCityJson(String codeIataCity) {
        final String uri ="http://aviation-edge.com/v2/public/cityDatabase?key=" + FLIGHT_API_KEY + "&codeIataCity=" + codeIataCity;
        return getJson(uri);
    }
    /**
     * Give Flight details in json data.
     * @param iataCode Code of the flight from IATA system.
     * @return Json with flight information.
     */
    public String getFlightsJson(String iataCode) {
        final String uri = "http://aviation-edge.com/v2/public/timetable?key=" + FLIGHT_API_KEY + "&iataCode=" + iataCode + "&type=departure";
        return getJson(uri);
    }
    /**
     * Give in json data actual weather details in place described by latitude and longitude.
     * @param latitude Latitude of the location.
     * @param longitude Longitude of the location.
     * @return Json with weather information.
     */
    public String getWeatherJson(double latitude, double longitude) {
        final String uri ="https://api.openweathermap.org/data/2.5/weather?lat="+latitude+"&lon="+longitude+"&appid=" + WEATHER_API_KEY +"&units=metric";
        return getJson(uri);
    }
    /**
     * Gets json from REST api under given url.
     * @param uri Url of REST API.
     * @return Json data from REST API.
     */
    private String getJson(String uri){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri,String.class);
    }
}
