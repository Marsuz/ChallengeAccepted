package pl.accepted.challenge.services.logging;


import org.springframework.beans.factory.annotation.Autowired;
import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.UserDAO;

/**
 * Created by Marcin on 2016-03-18.
 */


public class Authenticator {

    @Autowired
    UserDAO userDAO;

    public boolean authorize(long id, String hashedPass) {

        User user = userDAO.findByIds(id).get(0);

        if(user.getHashedPass().equals(hashedPass)) return true;

        return false;

    }

}
