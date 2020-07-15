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

        @Override
        public boolean equals(Object obj) {
            boolean equal = true;
            try{
                WeatherDesc wd = (WeatherDesc) obj;
                if(this.description!=null && !this.description.equals(wd.description)){
                    return false;
                }
                else if(this.icon!=null && !this.icon.equals(wd.icon)){
                    return false;
                }
                else if(this.description==null && wd.description!=null){
                    return false;
                }
                else if(this.icon==null && wd.icon!=null){
                    return false;
                }
            }catch(Exception e){
                return false;
            }
            return true;

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
    public Weather(String description, String icon, double temp){
        WeatherDesc[] wds = new WeatherDesc[1];
        wds[0] = new WeatherDesc(description, icon);
        weatherDescs = wds;
        main = new Main(temp);
    }
    @Override
    public boolean equals(Object obj) {
        try{
            Weather c = (Weather) obj;
            if(c==null) {
                return false;
            }
            else if (main.temp== c.main.temp && weatherDescs.length == c.getWeatherDescs().length){
                for (int i=0; i< weatherDescs.length; i++) {
                    if(!weatherDescs[i].equals(c.weatherDescs[i])){
                        return false;
                    }
                }
            }
            else{
                return false;}

        }catch(Exception e){
            return false;
        }
        return true;
    }

}