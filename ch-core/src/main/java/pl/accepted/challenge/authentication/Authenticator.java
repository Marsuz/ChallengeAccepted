package pl.accepted.challenge.authentication;

import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import pl.accepted.challenge.persistence.AssignedTokenRepository;
import security.AssignedToken;

import java.time.LocalDateTime;

@Service
public class Authenticator {
    private static final int validityOfSecurityTokenInDays = 7;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private AssignedTokenRepository assignedTokenRepository;

    public String createAndAssignTokenToUser(User user) {
        String tokenToReturn = tokenGenerator.generateUniqueToken();
        String hashedToken = hashString(tokenToReturn);
        final LocalDateTime expirationDate = LocalDateTime.now().plusDays(validityOfSecurityTokenInDays);
        assignedTokenRepository.save(new AssignedToken(hashedToken, user, expirationDate));
        return tokenToReturn;
    }

    private String hashString(String toBeHashed) {
        return DigestUtils.md5DigestAsHex(toBeHashed.getBytes());
    }
}
