package weather.viewer.data;

import org.junit.Assert;
import weather.viewer.model.*;

/**
 * Created by james on 30/12/2016.
 */
public class FixedTestData {

    public static CurrentWeatherData forMoscow() {

        CurrentWeatherData currentWeatherData = new CurrentWeatherData();

        currentWeatherData.setCoord(new Coord());
        currentWeatherData.getCoord().setLat("55.75");
        currentWeatherData.getCoord().setLon("37.62");

        currentWeatherData.setWeather(new Weather[] { new Weather() });
        currentWeatherData.getWeather()[0].setId("803");
        currentWeatherData.getWeather()[0].setMain("Clouds");
        currentWeatherData.getWeather()[0].setDescription("broken clouds");
        currentWeatherData.getWeather()[0].setIcon("04n");

        currentWeatherData.setBase("stations");

        currentWeatherData.setMain(new Main());
        currentWeatherData.getMain().setTemp("269.82");
        currentWeatherData.getMain().setPressure("1028");
        currentWeatherData.getMain().setHumidity("86");
        currentWeatherData.getMain().setTemp_min("269.15");
        currentWeatherData.getMain().setTemp_max("270.15");


        currentWeatherData.setVisibility("10000");

        currentWeatherData.setWind(new Wind());
        currentWeatherData.getWind().setSpeed("7");
        currentWeatherData.getWind().setDeg("230");

        currentWeatherData.setClouds(new Clouds());
        currentWeatherData.getClouds().setAll("75");

        currentWeatherData.setDt("1483038000");

        currentWeatherData.setSys(new Sys());
        currentWeatherData.getSys().setType("1");
        currentWeatherData.getSys().setId("7323");
        currentWeatherData.getSys().setMessage("0.0024");
        currentWeatherData.getSys().setCountry("RU");
        currentWeatherData.getSys().setSunrise("1482991165");
        currentWeatherData.getSys().setSunset("1483016698");

        currentWeatherData.setId("524901");
        currentWeatherData.setName("Moscow");
        currentWeatherData.setCod("200");

        return currentWeatherData;
    }
}
