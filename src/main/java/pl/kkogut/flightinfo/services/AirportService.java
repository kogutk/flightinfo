package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.City;

public class AirportService extends Service {

    CityService cityService;
    AirportService airportService;

    public AirportService(Api api, CityService cityService) {
        super(api);
        this.cityService = cityService;
    }

    public AirportService(Api api, CityService cityService, AirportService airportService) {
        super(api);
        this.cityService = cityService;
        this.airportService = airportService;
    }

    public Airport getAirport(String iataCode){

        String result = api.getAirportJson(iataCode);
        Airport[] airports = getObjectFromJson(result, Airport[].class);

        if (airports!=null && airports[0]!=null){
            Airport airport = airports[0];
            City city = cityService.getCity(airport.getCodeIataCity());
            airport.setCity(city);
            return airport;
        }
        else {
            return null;
        }
    }
}
