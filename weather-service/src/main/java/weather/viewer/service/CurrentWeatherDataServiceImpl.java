package weather.viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.viewer.data.WeatherDataClient;
import weather.viewer.model.CurrentWeatherData;

/**
 * Created by james on 28/12/2016.
 */

@Service
public class CurrentWeatherDataServiceImpl implements CurrentWeatherDataService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    public CurrentWeatherData currentWeatherDataForCity(String city) {
        return weatherDataClient.getCurrentWeatherData(city);
    }
}