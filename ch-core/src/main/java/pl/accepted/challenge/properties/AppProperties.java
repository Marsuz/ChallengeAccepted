package pl.accepted.challenge.properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by wiktor on 13/04/16.
 */
@Component
public class AppProperties {

    private int validityOfSecurityTokenInDays;

    @Autowired
    public AppProperties(@Value("${security.tokens.validity.days}") int validityOfSecurityTokenInDays) {
        this.validityOfSecurityTokenInDays = validityOfSecurityTokenInDays;
    }

    public int getValidityOfSecurityTokenInDays() {
        return validityOfSecurityTokenInDays;
    }
}
