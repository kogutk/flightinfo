package pl.kkogut.flightinfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.kkogut.flightinfo.models.Airport;
import pl.kkogut.flightinfo.models.Flight;
import pl.kkogut.flightinfo.services.AirportService;
import pl.kkogut.flightinfo.services.FlightService;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@Controller
public class AirportController {
    private static StopWatch stopWatch = new StopWatch();

    @GetMapping("/airport")
    public String getFlights(@ModelAttribute("airport") Airport airport, Map<String, Object> model){
        stopWatch.start();
        if(airport.getCodeIataAirport()==null){
            airport = new Airport("WAW");
        }
        model.put("flights", FlightService.getFlights(airport.getCodeIataAirport()));
        model.put("airport", AirportService.getAirport(airport.getCodeIataAirport()));
        model.put("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"));
        stopWatch.stop();
        System.out.println("Controller Get = " + stopWatch.getTotalTimeSeconds());
        return "airport";
    }
    @PostMapping("/airport")
    public String postFlights(@ModelAttribute("airport") Airport airport, Map<String, Object> model){
        stopWatch.start();
        try {
            List<Flight> flights = FlightService.getFlights(airport.getCodeIataAirport());
            airport = AirportService.getAirport(airport.getCodeIataAirport());

            model.put("flights", flights);
            model.put("airport", airport);
            model.put("localDateTimeFormat", new SimpleDateFormat("yyyy-MM-dd'T'HH:mm"));

        }
        catch (Exception e){
            model.put("errorMessage","Couldnt get flights and airport info. Check Airport code.");

        }
        stopWatch.stop();
        System.out.println("Controller Put = " + stopWatch.getTotalTimeSeconds());
        return "airport";
    }
}
