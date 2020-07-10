package pl.kkogut.flightinfo.services;

import com.google.gson.Gson;
import org.springframework.web.client.RestTemplate;
import pl.kkogut.flightinfo.models.City;

public class CityService {
    public static City getCity(String codeIataCity){
        final String uri ="http://aviation-edge.com/v2/public/cityDatabase?key=1044c9-8e7a15&codeIataCity="+codeIataCity;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(uri,String.class);
//        System.out.println(result);
        City[] cities = new Gson().fromJson(result, City[].class);
        return cities[0];
    }

}
