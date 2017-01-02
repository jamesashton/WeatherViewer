package weather.viewer.service;

import net.sf.ehcache.Cache;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import weather.viewer.cache.CurrentWeatherCacheManagerImpl;
import weather.viewer.model.CurrentWeatherData;

/**
 * Created by james on 28/12/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/service-test-context.xml"})
public class CurrentWeatherDataServiceIT {

    private static final String TEST_CITY = "London";

    @Autowired
    CurrentWeatherDataService currentWeatherDataService;

    @Autowired
    CurrentWeatherCacheManagerImpl currentWeatherCacheManager;

    @Test
    public void currentWeatherDataServiceAvailable() {
        Assert.assertNotNull(currentWeatherDataService);
    }

    @Test
    public void checkThatGetCurrentWeatherDataReturnsDataForKnownCity() {
        CurrentWeatherData currentWeatherData = currentWeatherDataService.currentWeatherDataForCity("London");
        Assert.assertNotNull(currentWeatherData);
    }

    @Test
    public void testThatCurrentWeatherDataForCityResultIsAddedToCache() {
        Cache cache = currentWeatherCacheManager.getCache("currentWeatherCache");
        Assert.assertNotNull(cache);
        cache.removeAll();
        Assert.assertTrue(cache.getSize() == 0);
        currentWeatherDataService.currentWeatherDataForCity(TEST_CITY);
        Assert.assertTrue(cache.getSize() == 1);
        CurrentWeatherData currentWeatherData = (CurrentWeatherData) cache.get(cache.getKeys().get(0)).getObjectValue();
        Assert.assertTrue(currentWeatherData.getName().equals(TEST_CITY));
    }


}