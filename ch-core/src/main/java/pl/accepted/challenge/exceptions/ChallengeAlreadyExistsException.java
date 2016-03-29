package pl.accepted.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value = HttpStatus.CONFLICT,reason = "Challenge already exists")
public class ChallengeAlreadyExistsException extends Exception {
}
