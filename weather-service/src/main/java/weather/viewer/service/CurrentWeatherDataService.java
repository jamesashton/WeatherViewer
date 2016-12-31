package weather.viewer.service;

import org.springframework.stereotype.Service;
import weather.viewer.model.CurrentWeatherData;

/**
 * Created by james on 28/12/2016.
 */


public interface CurrentWeatherDataService {
    CurrentWeatherData currentWeatherDataForCity(String city);
}