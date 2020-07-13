package pl.kkogut.flightinfo.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.util.StopWatch;
import pl.kkogut.flightinfo.models.Flight;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.Weather;

public class FlightService extends Service {
    CityService cityService;
    AirportService airportService;

    public FlightService(Api api, CityService cityService) {
        super(api);
        this.cityService = cityService;
    }

    public List<Flight> getFlights(String iataCode){

        String result = api.getFlightsJson(iataCode);
        Flight[] flights = getObjectFromJson(result, Flight[].class);
        List<Flight> lf =Arrays.asList(flights);
        lf = setAdditionalInfo(lf);
        return lf;
    }

    private List<Flight> setAdditionalInfo(List<Flight> lf) {
        long startTime, endTime, weatherTime = 0, airportTime=0, counterWeather=0;

        List<Flight> list = new ArrayList<>();
        for (Flight f : lf) {
            if (f.getCodeshared() == null && !f.getStatus().equals("landed")) {

                startTime = System.nanoTime();
                f.setArrAirport(getAirportInfo(f));
                endTime = System.nanoTime();
                airportTime+= (endTime - startTime);

                startTime = System.nanoTime();
                f.setArrWeather(getWeatherInfo(f));
                endTime = System.nanoTime();
                weatherTime+= (endTime - startTime);
                counterWeather++;

                f.setNewStatus(getNewStatus(f.getStatus(), f.getDeparture().getDelay()));

                String scheduledTime = f.getDeparture().getScheduledTime();
                String estimatedTime = f.getDeparture().getEstimatedTime();

                if(scheduledTime == null && estimatedTime!=null){
                    f.getDeparture().setScheduledTime(estimatedTime);
                }
                list.add(f);
            }
        }

        System.out.println("Set additional info (milis): Airport  = " + airportTime/1000000);
        System.out.println("Set additional info (milis): Weather  = " + weatherTime/1000000);
        System.out.println("Set additional info (avg milis): Airport  = " + airportTime/(counterWeather+1)/1000000);
        System.out.println("Set additional info (avg milis): Weather  = " + weatherTime/(counterWeather+1)/1000000);
        System.out.println("Set additional info (count): Weather  = " + counterWeather);
        return list;
    }
    private Airport getAirportInfo(Flight flight) {
        String arrAirportIataCode = flight.getArrival().getIataCode();
        airportService = new AirportService(api, cityService);
        return airportService.getAirport(arrAirportIataCode);
    }

    private Weather getWeatherInfo(Flight flight) {
        WeatherService weatherService = new WeatherService(api);
        double lat, lon;
        Airport airport = flight.getArrAirport();
        lat = airport.getLatitudeAirport();
        lon = airport.getLongitudeAirport();

        return weatherService.getWeather(lat, lon);
    }
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
