package pl.kkogut.flightinfo.services;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.City;

public class AirportService {

    public static Airport getAirport(String iataCode){
        final String uri ="http://aviation-edge.com/v2/public/airportDatabase?key=1044c9-8e7a15&codeIataAirport="+iataCode;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri,String.class);
//        System.out.println(result);
        Airport[] airports = new Gson().fromJson(result, Airport[].class);
        Airport airport = airports[0];
        City city = CityService.getCity(airport.getCodeIataCity());
        airport.setCity(city);
        return airport;
    }


}
