package weather.viewer.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import weather.viewer.model.CurrentWeatherData;
import weather.viewer.service.CurrentWeatherDataService;

/**
 * Created by james on 31/12/2016.
 */
@RestController
@RequestMapping("/current")
public class CurrentWeatherController {

    @Autowired
    CurrentWeatherDataService currentWeatherDataService;

    @RequestMapping(value="/{city}",method = RequestMethod.GET)
    CurrentWeatherData currentWeatherForCity(@PathVariable("city") String city){
        CurrentWeatherData currentWeatherData = currentWeatherDataService.currentWeatherDataForCity(city);
        return currentWeatherData;
    }


}
