package pl.kkogut.flightinfo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class FlightsController {

    @GetMapping("/flights")
    public String flights(Map<String, Object> model){
        model.put("message", "This is Kogut message");
        return "flights";
    }
}
