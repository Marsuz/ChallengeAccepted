package pl.accepted.challenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.accepted.challenge.persistence.UserService;

@SpringBootApplication
@EnableAutoConfiguration
public class App {

    @Autowired
    private UserService userService;

    public static void main(String[] args) {
            SpringApplication.run(App.class, args);
    }

}
