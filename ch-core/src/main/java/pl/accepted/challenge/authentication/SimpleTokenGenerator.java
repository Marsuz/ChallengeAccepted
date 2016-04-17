package pl.accepted.challenge.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.accepted.challenge.persistence.AssignedTokenRepository;

import java.math.BigInteger;
import java.security.SecureRandom;

@Service
public class SimpleTokenGenerator implements TokenGenerator {
    private final SecureRandom secureRandom = new SecureRandom();

    @Autowired
    private AssignedTokenRepository assignedTokenRepository;


    @Override
    public String generateUniqueToken() {
        //FIXME
        //check if such generated token exists
        //Still not thread safe
        String token;
        do {
            token = new BigInteger(130, secureRandom).toString(32);
        } while (assignedTokenRepository.getByHashedToken(hashString(token)) != null);
        return token;
    }
}
