package pl.accepted.challenge.authentication;

import org.springframework.util.DigestUtils;

public interface TokenGenerator {
    String generateUniqueToken();

    default String hashString(String toBeHashed) {
        return DigestUtils.md5DigestAsHex(toBeHashed.getBytes());
    }
}
