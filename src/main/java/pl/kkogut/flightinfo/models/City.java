package pl.kkogut.flightinfo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private String cityId;
    private String nameCity;
    private String codeIataCity;
    private String codeIso2Country;
    private String latitudeCity;
    private String longitudeCity;
    private String timezone;
    private String GMT;
    private String geonameId;

    public City(String cityId, String nameCity, String codeIataCity, String codeIso2Country, String latitudeCity, String longitudeCity, String timezone, String GMT, String geonameId){
        this.cityId = cityId;
        this.nameCity = nameCity;
        this.codeIataCity = codeIataCity;
        this.codeIso2Country = codeIso2Country;
        this.latitudeCity = latitudeCity;
        this.longitudeCity = longitudeCity;
        this.timezone = timezone;
        this.GMT = GMT;
        this.geonameId = geonameId;
    }
}
