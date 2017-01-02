package weather.viewer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import weather.viewer.data.WeatherDataClient;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.util.CityValidator;

/**
 * Created by james on 28/12/2016.
 */

@Service
public class CurrentWeatherDataServiceImpl implements CurrentWeatherDataService {

    @Autowired
    private WeatherDataClient weatherDataClient;

    @Autowired
    private CityValidator cityValidator;

    public CurrentWeatherData currentWeatherDataForCity(String city) {
        return cityValidator.isValid(city) ? weatherDataClient.getCurrentWeatherData(city) : null;
    }
}