package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.City;

public class CityService extends Service{

    public CityService(Api api){
        super(api);
    }
    public City getCity(String codeIataCity){
        String result = api.getCityJson(codeIataCity);
        City[] cities = getObjectFromJson(result, City[].class);
        if(cities!=null){
            return cities[0];
        }
        else{
            return null;
        }
    }

}
