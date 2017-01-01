package weather.viewer.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(method = RequestMethod.GET)
    CurrentWeatherData currentWeatherForCity(@RequestParam("city") String city){
        CurrentWeatherData currentWeatherData = currentWeatherDataService.currentWeatherDataForCity(city);
        return currentWeatherData;
    }

}
