package pl.accepted.challenge.app;

/**
 * Created by Marcin on 2016-03-19.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
/**
 * Created by Marcin on 2016-03-18.
 */
@EnableAutoConfiguration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(value = "pl.accepted.challenge")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
