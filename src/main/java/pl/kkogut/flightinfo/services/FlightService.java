package pl.kkogut.flightinfo.services;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import pl.kkogut.flightinfo.models.*;
import java.util.ArrayList;
import java.util.List;

public class FlightService {

    public static List<Flight> getFlights(String iataCode){
        final String uri ="http://aviation-edge.com/v2/public/timetable?key=1044c9-8e7a15&iataCode=" + iataCode + "&type=departure";
        List<Flight> list = new ArrayList<>();

        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri,String.class);
//        System.out.println(result);
        Flight[] lf = new Gson().fromJson(result, Flight[].class);

        double lat, lon;
        String arrAirportIataCode;
        for (Flight f: lf){
            if(f.getCodeshared()==null && f.getStatus().equals("scheduled")) {
                arrAirportIataCode = f.getArrival().getIataCode();
                f.setArrAirport(AirportService.getAirport(arrAirportIataCode));
                Airport airport = f.getArrAirport();

                lat = airport.getLatitudeAirport();
                lon = airport.getLongitudeAirport();

                f.setArrWeather(WeatherService.getWeather(lat, lon));

                list.add(f);
            }
        }
        return list;
    }
}
