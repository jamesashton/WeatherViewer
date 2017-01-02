package weather.viewer.data;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.util.HttpClientHelper;

import java.io.IOException;

/**
 * Created by james on 28/12/2016.
 */

@Component
public class WeatherDataClientImpl implements WeatherDataClient {

    @Autowired
    HttpClientHelper httpClientHelper;

    @Value("${openweathermap.current.weather}")
    String serviceUrl;

    public CurrentWeatherData getCurrentWeatherData(String city) {
        try {
            String responseText = httpClientHelper.httpGetResponseAsString(serviceUrl + city);
            ObjectMapper objectMapper = new ObjectMapper();
            CurrentWeatherData result = objectMapper.readValue(responseText, CurrentWeatherData.class);
            return result;
        } catch (Exception e) {
            throw new RuntimeException("Error fetching current weather data for City:" + city, e);
        }
    }
}
