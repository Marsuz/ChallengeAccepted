package pl.accepted.challenge;

import challenges.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;

@SpringBootApplication
@EntityScan(basePackageClasses = User.class)
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
