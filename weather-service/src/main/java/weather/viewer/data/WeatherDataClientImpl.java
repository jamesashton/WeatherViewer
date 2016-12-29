package weather.viewer.data;

import org.springframework.stereotype.Component;
import weather.viewer.model.CurrentWeatherData;

/**
 * Created by james on 28/12/2016.
 */

@Component
public class WeatherDataClientImpl implements WeatherDataClient {

    public CurrentWeatherData fetchCurrentWeatherDataForCity(String city) {
        return null;
    }

}
