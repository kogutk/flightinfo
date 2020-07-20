package pl.kkogut.flightinfo.services;

import pl.kkogut.flightinfo.models.City;

public class CityService extends Service{

    public CityService(Api api){
        super(api);
    }

    /**
     * Give City detailed information.
     * <p>Serves City object for a given IATA City code.</p>
     * @param codeIataCity Code of the city from IATA system.
     * @return City object.
     */
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
