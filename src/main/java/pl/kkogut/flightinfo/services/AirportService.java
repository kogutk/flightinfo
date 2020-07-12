package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.City;

public class AirportService extends Service {

    public static Airport getAirport(String iataCode){

        String result = Api.getAirportJson(iataCode);
        Airport[] airports = getObjectFromJson(result, Airport[].class);

        if (airports!=null && airports[0]!=null){
            Airport airport = airports[0];
            City city = CityService.getCity(airport.getCodeIataCity());
            airport.setCity(city);
            return airport;
        }
        else {
            return null;
        }
    }
}
