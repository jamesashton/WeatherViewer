package weather.viewer.data;

import weather.viewer.model.CurrentWeatherData;

/**
 * Created by james on 28/12/2016.
 */
public interface WeatherDataClient {

    CurrentWeatherData fetchCurrentWeatherDataForCity(String city);

}
