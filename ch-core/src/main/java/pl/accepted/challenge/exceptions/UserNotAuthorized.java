package pl.accepted.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN, reason = "You are not authorized to this object")
public class UserNotAuthorized extends Exception {
}
