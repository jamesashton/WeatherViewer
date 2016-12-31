package weather.viewer.data;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import weather.viewer.model.CurrentWeatherData;

/**
 * Created by james on 29/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/service-test-context.xml"})
public class WeatherDataClientIT {

    public static final String TEST_CITY = "Moscow";

    @Autowired
    WeatherDataClient weatherDataClient;

    @Test
    public void testThatTheLiveWeatherServiceJsonStructureMatchesExpectations()  {
        CurrentWeatherData currentWeatherData = weatherDataClient.getCurrentWeatherData(TEST_CITY);
        Assert.assertTrue(currentWeatherData.getCoord().getLat().equals("55.75"));
        Assert.assertTrue(currentWeatherData.getCoord().getLon().equals("37.62"));

        Assert.assertTrue(currentWeatherData.getWeather()[0].getId().length() > 0);
        Assert.assertTrue(currentWeatherData.getWeather()[0].getMain().length() > 0);
        Assert.assertTrue(currentWeatherData.getWeather()[0].getDescription().length() > 0);
        Assert.assertTrue(currentWeatherData.getWeather()[0].getIcon().length() > 0);

        Assert.assertTrue(currentWeatherData.getBase().equals("stations"));

        Assert.assertTrue(currentWeatherData.getMain().getTemp().length() > 0);
        Assert.assertTrue(currentWeatherData.getMain().getPressure().length() > 0);
        Assert.assertTrue(currentWeatherData.getMain().getHumidity().length() > 0);
        Assert.assertTrue(currentWeatherData.getMain().getTemp_min().length() > 0);
        Assert.assertTrue(currentWeatherData.getMain().getTemp_max().length() > 0);

        Assert.assertTrue(currentWeatherData.getVisibility().length() > 0);

        Assert.assertTrue(currentWeatherData.getWind().getSpeed().length() > 0);
        Assert.assertTrue(currentWeatherData.getWind().getDeg().length() > 0);

        Assert.assertTrue(currentWeatherData.getClouds().getAll().length() > 0);

        Assert.assertTrue(currentWeatherData.getDt().length() > 0);

        Assert.assertTrue(currentWeatherData.getSys().getType().equals("1"));
        Assert.assertTrue(currentWeatherData.getSys().getId().length() > 0);
        Assert.assertTrue(currentWeatherData.getSys().getMessage().length() > 0);
        Assert.assertTrue(currentWeatherData.getSys().getCountry().equals("RU"));
        Assert.assertTrue(currentWeatherData.getSys().getSunrise().length() > 0);
        Assert.assertTrue(currentWeatherData.getSys().getSunset().length() > 0);

        Assert.assertTrue(currentWeatherData.getId().length() > 0);
        Assert.assertTrue(currentWeatherData.getName().equals("Moscow"));
        Assert.assertTrue(currentWeatherData.getCod().length() > 0);

        System.out.print(currentWeatherData);
    }


}
