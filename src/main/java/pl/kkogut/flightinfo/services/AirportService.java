package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.City;

public class AirportService extends Service {

    private final CityService cityService;

    public AirportService(Api api, CityService cityService) {
        super(api);
        this.cityService = cityService;
    }

    /**
     * Give Airport detailed information.
     * <p>Serves Airport object with City information for a given IATA Airport code.</p>
     * @param iataCode Code of the airport from IATA system.
     */
    public Airport getAirport(String iataCode){

        String result = getAirportJson(iataCode);
        Airport[] airports = getObjectFromJson(result, Airport[].class);

        if (airports!=null && airports[0]!=null){
            Airport airport = airports[0];
            String codeIataCity = airport.getCodeIataCity();
            City city = getCity(codeIataCity);
            airport.setCity(city);
            return airport;
        }
        else {
            return null;
        }
    }

    public String getAirportJson(String iataCode){
        return api.getAirportJson(iataCode);
    }
    public City getCity(String codeIataCity){
        return cityService.getCity(codeIataCity);
    }

}
