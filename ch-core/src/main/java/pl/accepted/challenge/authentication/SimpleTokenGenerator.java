package pl.accepted.challenge.authentication;

import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;

@Service
public class SimpleTokenGenerator implements TokenGenerator {
    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public String generateUniqueToken() {
        return new BigInteger(130, secureRandom).toString(32);
    }
}
