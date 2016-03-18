package pl.accepted.challenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Marcin on 2016-03-18.
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "pl.accepted.challenge")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
