package weather.viewer.service;

import org.junit.Assert;
import org.junit.Ignore;
import weather.viewer.model.CurrentWeatherData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by james on 28/12/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/service-test-context.xml"})
public class CurrentWeatherDataServiceIT {

    @Autowired
    CurrentWeatherDataService currentWeatherDataService;

    @Test
    public void currentWeatherDataServiceAvailable() {
        Assert.assertNotNull(currentWeatherDataService);
    }

    @Test
    public void checkThatGetCurrentWeatherDataReturnsDataForKnownCity() {
        CurrentWeatherData currentWeatherData = currentWeatherDataService.currentWeatherDataForCity("London");
        Assert.assertNotNull(currentWeatherData);
    }
}