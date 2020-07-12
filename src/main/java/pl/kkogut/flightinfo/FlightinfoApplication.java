package pl.kkogut.flightinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FlightinfoApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {

		SpringApplication.run(FlightinfoApplication.class, args);
	}

}
