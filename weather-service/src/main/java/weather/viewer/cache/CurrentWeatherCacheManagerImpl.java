package weather.viewer.cache;

import net.sf.ehcache.CacheManager;
import org.springframework.stereotype.Component;

/**
 * Created by james on 02/01/2017.
 */

@Component
public class CurrentWeatherCacheManagerImpl extends CacheManager {

    public CurrentWeatherCacheManagerImpl() {
        super();
    }

}
