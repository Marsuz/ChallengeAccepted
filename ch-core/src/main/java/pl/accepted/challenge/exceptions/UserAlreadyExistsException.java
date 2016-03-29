package pl.accepted.challenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "User already exists")
public class UserAlreadyExistsException  extends Exception{

    public UserAlreadyExistsException() {
    }

    public UserAlreadyExistsException(String s) {
        super(s);
    }

    public UserAlreadyExistsException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public UserAlreadyExistsException(Throwable throwable) {
        super(throwable);
    }

    public UserAlreadyExistsException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
