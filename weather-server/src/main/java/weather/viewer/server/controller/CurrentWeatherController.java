package weather.viewer.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.server.exception.HttpInternalServerErrorException;
import weather.viewer.server.exception.HttpNotFoundException;
import weather.viewer.service.CurrentWeatherDataService;

/**
 * Created by james on 31/12/2016.
 */
@RestController
@RequestMapping("/current")
public class CurrentWeatherController {

    @Autowired
    CurrentWeatherDataService currentWeatherDataService;

    @RequestMapping(method = RequestMethod.GET)
    CurrentWeatherData currentWeatherForCity(@RequestParam("city") String city){
        CurrentWeatherData currentWeatherData = null;
        try {
            currentWeatherData = currentWeatherDataService.currentWeatherDataForCity(city);
        } catch (Exception ex) {
            throw new HttpInternalServerErrorException("Unexpected error getting current weather data for city: " + city,ex);
        }
        if (currentWeatherData == null) {
            throw new HttpNotFoundException("Current weather data not found for city: " + city);
        }

        return currentWeatherData;
    }
}
