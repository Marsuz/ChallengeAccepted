package pl.accepted.challenge.authentication;

import model.AssignedToken;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.accepted.challenge.persistence.AssignedTokenRepository;
import pl.accepted.challenge.properties.AppProperties;

import java.time.LocalDateTime;

@Service
public class Authenticator {

    @Autowired
    private AppProperties appProperties;

    @Autowired
    private TokenGenerator tokenGenerator;

    @Autowired
    private AssignedTokenRepository assignedTokenRepository;

    public String createAndAssignTokenToUser(User user) {
        String tokenToReturn = tokenGenerator.generateUniqueToken();
        String hashedToken = tokenGenerator.hashString(tokenToReturn);
        final LocalDateTime expirationDate = LocalDateTime.now().plusDays(appProperties.getValidityOfSecurityTokenInDays());
        assignedTokenRepository.save(new AssignedToken(hashedToken, user, expirationDate));
        return tokenToReturn;
    }


}
