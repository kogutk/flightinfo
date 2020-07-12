package pl.kkogut.flightinfo.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class City {
    private String nameCity;
    private String codeIataCity;
    private String latitudeCity;
    private String longitudeCity;

    public City(String nameCity, String codeIataCity, String latitudeCity, String longitudeCity){
        this.nameCity = nameCity;
        this.codeIataCity = codeIataCity;
        this.latitudeCity = latitudeCity;
        this.longitudeCity = longitudeCity;
    }
}
