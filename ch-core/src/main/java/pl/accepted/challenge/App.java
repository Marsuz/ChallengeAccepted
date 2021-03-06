package pl.accepted.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@EntityScan(basePackages = {"model", "ch-core"})
@PropertySource("classpath:application.properties")
@ComponentScan({
		"pl.accepted.challenge.properties",
		"pl.accepted.challenge.services",
		"pl.accepted.challenge.controllers",
		"pl.accepted.challenge.persistence",
		"pl.accepted.challenge.authentication"
})
@EnableAutoConfiguration(exclude = {
		org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration.class
})
public class App {

	@Bean
	static PropertySourcesPlaceholderConfigurer propertyPlaceHolderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
	}

}
