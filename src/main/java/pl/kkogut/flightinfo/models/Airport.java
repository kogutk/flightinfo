package pl.kkogut.flightinfo.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Getter
@Setter
@RequiredArgsConstructor
public class Airport {
    private  String GMT;
    private String codeIataAirport;
    private String codeIataCity;
    private double latitudeAirport;
    private double longitudeAirport;
    private String nameAirport;
    private String nameCountry;
    private String timezone;
    private City city;

    public Airport(String codeIataAirport){
        this.codeIataAirport= codeIataAirport;
        this.GMT = null;
        this.codeIataCity = null;
        this.latitudeAirport = 0;
        this.longitudeAirport = 0;
        this.nameAirport = null;
        this.nameCountry = null;
        this.timezone = null;
        this.city = null;
    }
    public Airport(String codeIataAirport, String codeIataCity){
        this.codeIataAirport= codeIataAirport;
        this.GMT = null;
        this.codeIataCity = codeIataCity;
        this.latitudeAirport = 0;
        this.longitudeAirport = 0;
        this.nameAirport = null;
        this.nameCountry = null;
        this.timezone = null;
        this.city = null;
    }
    public String getLocalTime(){
        LocalDateTime time = getNow();
        String gmt = getGMT();
        if(gmt!=null && !gmt.equals("")){
            short dif = Short.parseShort(gmt);
            time = time.plusHours(dif);
        }
        return time.toString();
    }
    public LocalDateTime getNow(){
        return LocalDateTime.now(ZoneOffset.UTC).plusHours(1);
    }


    @Override
    public boolean equals(Object obj) {
        try{
            Airport a = (Airport) obj;
            return this.codeIataAirport.equals(a.codeIataAirport); //simplification for testing purposes

        }catch(Exception e){
            return false;
        }
    }
}
