package weather.viewer.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by james on 01/01/2017.
 */
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class HttpInternalServerErrorException extends RuntimeException {
    public HttpInternalServerErrorException(String message) {
        super(message);
    }

    public HttpInternalServerErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
