package pl.kkogut.flightinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
/**
 * @author      Krzysztof Kogut <kogutk@gmail.com>
 * @version     1.0
 * @since       1.0
 */
@SpringBootApplication
public class FlightinfoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FlightinfoApplication.class, args);
	}

}
