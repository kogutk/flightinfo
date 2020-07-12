package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.City;

public class CityService extends Service{
    public static City getCity(String codeIataCity){
        String result = Api.getCityJson(codeIataCity);
        City[] cities = getObjectFromJson(result, City[].class);
        if(cities!=null){
            return cities[0];
        }
        else{
            return null;
        }
    }

}
