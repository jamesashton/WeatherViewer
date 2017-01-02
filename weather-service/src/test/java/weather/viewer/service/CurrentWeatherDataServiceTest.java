package weather.viewer.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.verification.VerificationModeFactory;
import weather.viewer.data.FixedTestData;
import weather.viewer.data.WeatherDataClient;
import weather.viewer.data.WeatherDataClientImpl;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.util.CityValidator;

import java.io.File;
import java.io.IOException;

/**
 * Created by james on 28/12/2016.
 */


public class CurrentWeatherDataServiceTest {

    private static final String TEST_CITY = "Moscow";

    @InjectMocks
    private CurrentWeatherDataService currentWeatherDataService = new CurrentWeatherDataServiceImpl();

    @Mock
    private WeatherDataClient weatherDataClient;

    @Mock
    private CityValidator cityValidator;

    @Before
    public void setup() throws IOException {
        MockitoAnnotations.initMocks(this);
        Mockito.when(weatherDataClient.getCurrentWeatherData(TEST_CITY)).thenReturn(FixedTestData.forMoscow());
        Mockito.when(cityValidator.isValid(TEST_CITY)).thenReturn(true);
    }

    @Test
    public void testThatCurrentWeatherDataForCityMakesASingleCallToWeatherDataClient() {
        currentWeatherDataService.currentWeatherDataForCity(TEST_CITY);
        Mockito.verify(weatherDataClient, VerificationModeFactory.only()).getCurrentWeatherData(TEST_CITY);
    }

    @Test
    public void testThatCurrentWeatherDataForCityReturnsAnInstanceOfCurrentWeatherData() {
        CurrentWeatherData currentWeatherData = currentWeatherDataService.currentWeatherDataForCity(TEST_CITY);
        Assert.assertNotNull(currentWeatherData);
        Assert.assertTrue(currentWeatherData.getName().equals("Moscow"));
    }

}
