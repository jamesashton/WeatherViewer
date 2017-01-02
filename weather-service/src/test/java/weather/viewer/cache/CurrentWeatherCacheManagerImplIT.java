package weather.viewer.cache;

import net.sf.ehcache.Cache;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.service.CurrentWeatherDataService;

/**
 * Created by james on 02/01/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/service-test-context.xml"})
public class CurrentWeatherCacheManagerImplIT {

    private static final String TEST_CITY = "London";

    @Autowired
    CurrentWeatherDataService currentWeatherDataService;

    @Autowired
    CurrentWeatherCacheManagerImpl currentWeatherCacheManager;

    @Test
    public void testThatCacheExpiresAfterSpecifiedTime() throws InterruptedException {
        Cache cache = currentWeatherCacheManager.getCache("currentWeatherCache");
        currentWeatherDataService.currentWeatherDataForCity(TEST_CITY);
        Assert.assertEquals(1, cache.getSize());
        Thread.sleep(1100);
        cache.get(cache.getKeys().get(0));
        Assert.assertEquals(0,cache.getSize());
    }
}
