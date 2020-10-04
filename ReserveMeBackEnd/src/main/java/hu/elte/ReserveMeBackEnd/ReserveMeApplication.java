package hu.elte.ReserveMeBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class ReserveMeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReserveMeApplication.class, args);
	}

}
