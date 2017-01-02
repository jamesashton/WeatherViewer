package weather.viewer.server.exception;

/**
 * Created by james on 01/01/2017.
 */

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HttpNotFoundException extends RuntimeException {
    public HttpNotFoundException(String s) {
        super(s);
    }
}
