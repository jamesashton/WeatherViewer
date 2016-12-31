package weather.viewer.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by james on 29/12/2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/service-test-context.xml"})
public class HttpClientHelperIT {

    @Autowired
    HttpClientHelper httpClientHelper;

    @Test
    public void testThatHttpGetResponseAsStringReturnsDataFromAValidUrl() {
        String responseText = httpClientHelper.httpGetResponseAsString("http://api.openweathermap.org/data/2.5/weather?APPID=f473da5eb979928fc8ba6368841982ed&q=London");
        System.out.print(responseText);
        Assert.assertTrue(responseText.length() > 0);
    }

}