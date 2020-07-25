package pl.kkogut.flightinfo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pl.kkogut.flightinfo.models.Flight;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.Weather;

public class FlightService extends Service {

    private final AirportService airportService;

    public FlightService(Api api, AirportService airportService) {
        super(api);
        this.airportService = airportService;
    }
    /**
     * Give detailed information about flights.
     * <p>Serves List of Flight object with additional information for each, for a given IATA flight code.</p>
     * @param iataCode Code of the flight from IATA system.
     * @return List of flights.
     */
    public List<Flight> getFlights(String iataCode){
        String result = api.getFlightsJson(iataCode);
        Flight[] flights = getObjectFromJson(result, Flight[].class);
        List<Flight> lf =Arrays.asList(flights);
        lf = setAdditionalInfo(lf);
        return lf;
    }
    /**
     * Adds information about weather, airport and mapped status.
     * <p>Adds to each of the list of flights information about weather, airport and mapped status.</p>
     * @param lf List of Flight objects which to add information.
     * @return List of flights with additional info.
     */
    private List<Flight> setAdditionalInfo(List<Flight> lf) {
        List<Flight> list = new ArrayList<>();
        for (Flight f : lf) {
            if (f.getCodeshared() == null && !f.getStatus().equals("landed")) {

                f.setArrAirport(getAirportInfo(f));
                f.setArrWeather(getWeatherInfo(f));
                f.setNewStatus(getNewStatus(f.getStatus(), f.getDeparture().getDelay()));

                String scheduledTime = f.getDeparture().getScheduledTime();
                String estimatedTime = f.getDeparture().getEstimatedTime();

                if(scheduledTime == null && estimatedTime!=null){
                    f.getDeparture().setScheduledTime(estimatedTime);
                }
                list.add(f);
            }
        }
        return list;
    }
    /**
     * Get arrival airport details.
     * <p>Serves arrival Airport object for a given Flight.</p>
     * @param flight Flight to get Airport.
     * @return Airport object for given Flight.
     */
    private Airport getAirportInfo(Flight flight) {
        String arrAirportIataCode = flight.getArrival().getIataCode();
        return airportService.getAirport(arrAirportIataCode);
    }
    /**
     * Get actual weather details.
     * <p>Serves Weather object for a arrival location for a given Flight.</p>
     * @param flight Flight to get weather.
     * @return Weather object for arrival location fo a given Flight.
     */
    private Weather getWeatherInfo(Flight flight) {
        WeatherService weatherService = new WeatherService(api);
        double lat, lon;
        Airport airport = flight.getArrAirport();
        lat = airport.getLatitudeAirport();
        lon = airport.getLongitudeAirport();

        return weatherService.getWeather(lat, lon);
    }
    /**
     * Maps flight's status.
     * <p>Maps flight's status from external to internal for a given external
     * status and delay information. Returns more understandable status.</p>
     * @param status Flight's external status took from external API.
     * @param delay Delay value for flight took from external API.
     * @return String with new status.
     */
    public String getNewStatus(String status, String delay){
        String newStatus;
        if(status==null){
            return null;
        }
        else if(status.equals("scheduled") && delay!=null){
            newStatus = "delayed";
        }
        else if (status.equals("active")) {
            newStatus = "took off";
        }
        else{
            newStatus = status;
        }
        return newStatus;

    }
}
