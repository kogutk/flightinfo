package pl.kkogut.flightinfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.services.AirportService;
import pl.kkogut.flightinfo.services.FlightService;

import java.text.SimpleDateFormat;
import java.util.Map;

@Controller
public class AirportController {

    @GetMapping("/airport")
    public String getFlights(@ModelAttribute("airport") Airport airport, Map<String, Object> model){
        if(airport.getCodeIataAirport()==null){
            airport = new Airport("WAW");
        }
        model.put("flights", FlightService.getFlights(airport.getCodeIataAirport()));
        model.put("airport", AirportService.getAirport(airport.getCodeIataAirport()));
        model.put("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        return "airport";
    }
    @PostMapping("/airport")
    public String postFlights(@ModelAttribute("airport") Airport airport, Map<String, Object> model){
        model.put("flights", FlightService.getFlights(airport.getCodeIataAirport()));
        model.put("airport", AirportService.getAirport(airport.getCodeIataAirport()));
        model.put("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'hh:mm"));
        return "airport";
    }
}
