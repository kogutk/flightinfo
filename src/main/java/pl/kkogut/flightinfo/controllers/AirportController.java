package pl.kkogut.flightinfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.City;
import pl.kkogut.flightinfo.models.Flight;
import pl.kkogut.flightinfo.services.AirportService;
import pl.kkogut.flightinfo.services.Api;
import pl.kkogut.flightinfo.services.CityService;
import pl.kkogut.flightinfo.services.FlightService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class AirportController {

    private Api api = new Api();
    private CityService cityService = new CityService(api);
    private AirportService airportService = new AirportService(api, cityService);
    private FlightService flightService = new FlightService(api, airportService);

    @GetMapping("/")
    public String getFlights(@ModelAttribute("airport") Airport airport, Map<String, Object> model){
        serveModel(airport,model);
        return "airport";
    }
    @PostMapping("/")
    public String postFlights(@ModelAttribute("airport") Airport airport, Map<String, Object> model){
        serveModel(airport,model);
        return "airport";
    }

    private void serveModel(Airport airport, Map<String, Object> model){
        if(airport.getCodeIataAirport()==null || airport.getCodeIataAirport()==""){
            airport = new Airport("WAW");
        }

        String iataCode = airport.getCodeIataAirport();

//        try {
            airport = airportService.getAirport(iataCode);
            List<Flight> flights = flightService.getFlights(iataCode);


            model.put("flights", flights);
            model.put("airport", airport);
            model.put("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"));
//        }
//        catch (Exception e){
//            model.put("errorMessage","Couldnt get flights and airport info. Check Airport code.");
//
//        }

    }
}
