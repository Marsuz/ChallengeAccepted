package app;

/**
 * Created by Marcin on 2016-03-19.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
/**
 * Created by Marcin on 2016-03-18.
 */

@SpringBootApplication
@ComponentScan(value = "pl.accepted.challenge")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
