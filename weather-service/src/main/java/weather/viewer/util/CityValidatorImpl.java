package weather.viewer.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by james on 01/01/2017.
 */
@Component
public class CityValidatorImpl implements CityValidator {

    @Value("${cities.available}")
    String citiesAvailable;

    @Override
    public boolean isValid(String city) {
        if (city.length() == 0) {
            return false;
        }
        return citiesAvailable.contains( city.replace(",","") );
    }

}
