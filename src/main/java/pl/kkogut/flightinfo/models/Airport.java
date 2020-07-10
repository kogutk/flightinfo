package pl.kkogut.flightinfo.models;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;

@Getter
@Setter
public class Airport {
    private String GMT;
    private long airportId;
    private String codeIataAirport;
    private String codeIataCity;
    private String codeIcaoAirport;
    private String codeIso2Country;
    private String geonameId;
    private double latitudeAirport;
    private double longitudeAirport;
    private String nameAirport;
    private String nameCountry;
    private String phone;
    private String timezone;
    private City city;

    public Airport(){
    }

    public Airport(String codeIataAirport){
        this.GMT= null;
        this.airportId= 0;
        this.codeIataAirport= codeIataAirport;
        this.codeIataCity= null;
        this.codeIcaoAirport= null;
        this.codeIso2Country= null;
        this.geonameId= null;
        this.latitudeAirport= 0;
        this.longitudeAirport= 0;
        this.nameAirport= null;
        this.nameCountry= null;
        this.phone= null;
        this.timezone= null;
    }
    public Airport(String GMT, long airportId, String codeIataAirport, String codeIataCity, String codeIcaoAirport, String codeIso2Country, String geonameId, double latitudeAirport, double longitudeAirport, String nameAirport, String nameCountry, String phone, String timezone){
        this.GMT = GMT;
        this.airportId = airportId;
        this.codeIataAirport = codeIataAirport;
        this.codeIataCity = codeIataCity;
        this.codeIcaoAirport = codeIcaoAirport;
        this.codeIso2Country = codeIso2Country;
        this.geonameId = geonameId;
        this.latitudeAirport = latitudeAirport;
        this.longitudeAirport = longitudeAirport;
        this.nameAirport = nameAirport;
        this.nameCountry = nameCountry;
        this.phone = phone;
        this.timezone = timezone;
    }
    public String getLocalTime(){

        LocalDateTime time = LocalDateTime.now();
        if(getGMT()!=null){
            short dif = Short.parseShort(getGMT());
            time = time.plusHours(dif);
        }
        return time.toString();

    }
}
