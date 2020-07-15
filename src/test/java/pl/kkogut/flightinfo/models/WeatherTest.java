package pl.kkogut.flightinfo.models;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {

    @Test
    void should_check_weather_equality_with_one_weather_desc() {
        Weather w = new Weather("scattered clouds","03d",34.85d);
        Weather wSame = new Weather("scattered clouds","03d",34.85d);
        Weather wDiff1 = new Weather("abc","03d",34.85d);
        Weather wDiff2 = new Weather("scattered clouds","03d",0.0d);
        Weather wDiff3 = new Weather("scattered clouds"," 03d",34.85d);
        Weather wDiff4 = new Weather("scattered clouds","03d",34.85123d);
        Weather wDiff5 = new Weather(null,"03d",34.85d);
        Weather wDiff6 = new Weather("scattered clouds",null,34.85d);
        Weather wDiff7 = new Weather("scattered clouds","03d",0);

//
//        Weather.WeatherDesc wd = new Weather.WeatherDesc("scattered clouds","03d");
//        Weather.WeatherDesc[] wds = new Weather.WeatherDesc[1];
//        wds[0]=wd;
//        Weather.Main wm = new Weather.Main(34.85d);

        Assert.assertEquals(wSame,w);
        Assert.assertNotEquals(wDiff1,w);
        Assert.assertNotEquals(wDiff2,w);
        Assert.assertNotEquals(wDiff3,w);
        Assert.assertNotEquals(wDiff4,w);
        Assert.assertNotEquals(wDiff5,w);
        Assert.assertNotEquals(wDiff6,w);
        Assert.assertNotEquals(wDiff7,w);

    }
    @Test
    void should_check_weather_equality_with_no_weather_descs() {

        Weather.WeatherDesc wd = new Weather.WeatherDesc("scattered clouds","03d");
        Weather.WeatherDesc[] wds = new Weather.WeatherDesc[1];
        wds[0]=wd;
        Weather.Main wm = new Weather.Main(34.85d);
        Weather w = new Weather(wds,wm);

        Weather.WeatherDesc[] wdsTest = new Weather.WeatherDesc[1];
        Weather.Main wmTest = new Weather.Main(34.85d);
        Weather wTest = new Weather(wdsTest,wmTest);

        Assert.assertNotEquals(wTest,w);

    }
    @Test
    void should_check_weather_equality_with_different_weather_desc_count() {
        Weather.WeatherDesc wd = new Weather.WeatherDesc("scattered clouds","03d");
        Weather.WeatherDesc[] wds = new Weather.WeatherDesc[1];
        wds[0]=wd;
        Weather.Main wm = new Weather.Main(34.85d);
        Weather w = new Weather(wds,wm);

        Weather.WeatherDesc[] wdsTest = new Weather.WeatherDesc[3];
        wdsTest[0] =  new Weather.WeatherDesc("scattered clouds","03d");
        wdsTest[1] =  new Weather.WeatherDesc("abc","03d");
        wdsTest[2] =  new Weather.WeatherDesc("scattered clouds",null);
        Weather.Main wmTest = new Weather.Main(34.85d);
        Weather wTest = new Weather(wdsTest,wmTest);

        Assert.assertNotEquals(wTest,w);

    }
    @Test
    void should_check_weather_equality_with_same_weather_desc_count() {
        Weather.WeatherDesc[] wds = new Weather.WeatherDesc[3];
        wds[0] =  new Weather.WeatherDesc("scattered clouds","03d");
        wds[1] =  new Weather.WeatherDesc("abc","03d");
        wds[2] =  new Weather.WeatherDesc("scattered clouds",null);
        Weather.Main wm = new Weather.Main(34.85d);
        Weather w = new Weather(wds,wm);

        Weather.WeatherDesc[] wdsTest = new Weather.WeatherDesc[3];
        wdsTest[0] =  new Weather.WeatherDesc("scattered clouds","03d");
        wdsTest[1] =  new Weather.WeatherDesc("abc","03d");
        wdsTest[2] =  new Weather.WeatherDesc("scattered clouds",null);
        Weather.Main wmTest = new Weather.Main(34.85d);
        Weather wTest = new Weather(wdsTest,wmTest);

        Assert.assertEquals(wTest,w);

    }

}