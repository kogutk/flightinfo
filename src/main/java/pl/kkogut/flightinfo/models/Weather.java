package pl.kkogut.flightinfo.models;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Weather {
    @SerializedName("weather")
    private WeatherDesc[] weatherDescs;
    private Main main;

    public Weather(WeatherDesc[] weatherDescs, Main main){
        this.weatherDescs = weatherDescs;
        this.main = main;
    }

    @Getter
    @Setter
    public static class WeatherDesc {
        private String description;
        private String icon;

        public WeatherDesc(String description, String icon){
            this.description = description;
            this.icon = icon;
        }
    }
    @Getter
    @Setter
    public static class Main {
        private double temp;

        public Main(double temp){
            this.temp = temp;
        }
    }
}