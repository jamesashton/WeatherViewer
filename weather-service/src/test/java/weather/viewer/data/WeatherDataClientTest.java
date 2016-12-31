package weather.viewer.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.test.util.ReflectionTestUtils;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.util.HttpClientHelper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by james on 29/12/2016.
 */
public class WeatherDataClientTest {

    private static final String TEST_URL = "www.nowhere.xom";
    private static final String TEST_CITY = "Moscow";

    @InjectMocks
    private WeatherDataClient weatherDataClient;

    @Mock
    private HttpClientHelper httpClientHelper;

    @Before
    public void setup() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("data/currentweatherdata.json").getFile());
        String json = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
        weatherDataClient = new WeatherDataClientImpl();
        ReflectionTestUtils.setField(weatherDataClient, "serviceUrl", TEST_URL);
        MockitoAnnotations.initMocks(this);
        Mockito.when(httpClientHelper.httpGetResponseAsString(TEST_URL + TEST_CITY)).thenReturn(json);
    }

    @Test
    public void testGetCurrentWeatherDataCallsHttpClientHelperOnceToFetchData() {
        weatherDataClient.getCurrentWeatherData(TEST_CITY);
        Mockito.verify(httpClientHelper, VerificationModeFactory.times(1)).httpGetResponseAsString(TEST_URL + TEST_CITY);
    }

    @Test
    public void testGetCurrentWeatherDataCorrectlyMapsJsonResponseToModelObjects() {
        CurrentWeatherData currentWeatherData = weatherDataClient.getCurrentWeatherData(TEST_CITY);

        Assert.assertTrue(currentWeatherData.getCoord().getLat().equals("55.75"));
        Assert.assertTrue(currentWeatherData.getCoord().getLon().equals("37.62"));

        Assert.assertTrue(currentWeatherData.getWeather()[0].getId().equals("803"));
        Assert.assertTrue(currentWeatherData.getWeather()[0].getMain().equals("Clouds"));
        Assert.assertTrue(currentWeatherData.getWeather()[0].getDescription().equals("broken clouds"));
        Assert.assertTrue(currentWeatherData.getWeather()[0].getIcon().equals("04n"));

        Assert.assertTrue(currentWeatherData.getBase().equals("stations"));

        Assert.assertTrue(currentWeatherData.getMain().getTemp().equals("269.82"));
        Assert.assertTrue(currentWeatherData.getMain().getPressure().equals("1028"));
        Assert.assertTrue(currentWeatherData.getMain().getHumidity().equals("86"));
        Assert.assertTrue(currentWeatherData.getMain().getTemp_min().equals("269.15"));
        Assert.assertTrue(currentWeatherData.getMain().getTemp_max().equals("270.15"));

        Assert.assertTrue(currentWeatherData.getVisibility().equals("10000"));

        Assert.assertTrue(currentWeatherData.getWind().getSpeed().equals("7"));
        Assert.assertTrue(currentWeatherData.getWind().getDeg().equals("230"));

        Assert.assertTrue(currentWeatherData.getClouds().getAll().equals("75"));

        Assert.assertTrue(currentWeatherData.getDt().equals("1483038000"));

        Assert.assertTrue(currentWeatherData.getSys().getType().equals("1"));
        Assert.assertTrue(currentWeatherData.getSys().getId().equals("7323"));
        Assert.assertTrue(currentWeatherData.getSys().getMessage().equals("0.0024"));
        Assert.assertTrue(currentWeatherData.getSys().getCountry().equals("RU"));
        Assert.assertTrue(currentWeatherData.getSys().getSunrise().equals("1482991165"));
        Assert.assertTrue(currentWeatherData.getSys().getSunset().equals("1483016698"));

        Assert.assertTrue(currentWeatherData.getId().equals("524901"));
        Assert.assertTrue(currentWeatherData.getName().equals("Moscow"));
        Assert.assertTrue(currentWeatherData.getCod().equals("200"));

    }


}