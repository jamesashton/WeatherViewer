package weather.viewer.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:spring/service-context.xml")
public class WeatherServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherServerApplication.class, args);
	}
}
