package pl.kkogut.flightinfo.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    private Coord coord;
    @SerializedName("weather")
    private WeatherDesc[] weatherDescs;
    private String base;
    private Main main;
    private long visibility;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private Snow snow;
    private long dt;
    private Sys sys;
    private long timezone;
    private long id;
    private String name;
    private long cod;

    public Weather(Coord coord, WeatherDesc[] weatherDescs, String base, Main main, long visibility, Wind wind, Clouds clouds, long dt, Sys sys, long timezone, long id, String name, long cod){
        this.coord = coord;
        this.weatherDescs = weatherDescs;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.timezone = timezone;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }
    @Getter
    @Setter
    public static class Coord {
        private double lon;
        private double lat;

        public Coord(double lon, double lat){
            this.lon = lon;
            this.lat = lat;
        }
    }
    @Getter
    @Setter
    public static class WeatherDesc {
        private long id;
        private String main;
        private String description;
        private String icon;

        public WeatherDesc(long id, String main, String description, String icon){
            this.id = id;
            this.main = main;
            this.description = description;
            this.icon = icon;
        }
    }
    @Getter
    @Setter
    public static class Main {
        private double temp;
        private double feels_like;
        private double temp_min;
        private double temp_max;
        private long pressure;
        private long humidity;

        public Main(double temp, double feels_like, double temp_min, double temp_max, long pressure, long humidity){
            this.temp = temp;
            this.feels_like = feels_like;
            this.temp_min = temp_min;
            this.temp_max = temp_max;
            this.pressure = pressure;
            this.humidity = humidity;
        }
    }
    @Getter
    @Setter
    public static class Wind {
        private double speed;
        private long deg;
        private double gust;

        public Wind(double speed, long deg, double gust){
            this.speed = speed;
            this.deg = deg;
            this.gust = gust;
        }
    }
    @Getter
    @Setter
    public static class Clouds {
        private long all;

        public Clouds(long all){
            this.all = all;
        }
    }
    @Getter
    @Setter
    public static class Rain {
        @SerializedName("1h")
        private double oneH;
        @SerializedName("3h")
        private double threeH;

        public Rain(double oneH, double threeH){
            this.oneH = oneH;
            this.threeH = threeH;
        }
    }
    @Getter
    @Setter
    public static class Snow {
        @SerializedName("1h")
        private double oneH;
        @SerializedName("3h")
        private double threeH;


        public Snow(double oneH, double threeH){
            this.oneH = oneH;
            this.threeH = threeH;
        }
    }
    public static class Sys {
        private long type;
        private long id;
        private String country;
        private long sunrise;
        private long sunset;

        public Sys(long type, long id, String country, long sunrise, long sunset){
            this.type = type;
            this.id = id;
            this.country = country;
            this.sunrise = sunrise;
            this.sunset = sunset;
        }
    }
}