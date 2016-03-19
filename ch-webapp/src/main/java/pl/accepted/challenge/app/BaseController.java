package pl.accepted.challenge.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.UserDAO;

/**
 * Created by Marcin on 2016-03-19.
 */

@RestController
public class BaseController {

    @Autowired
    UserDAO userDAO;

    @RequestMapping("/testing")
    public String getHome(){
        userDAO.updateUsers(new User("Mateusz", "Kmiecik", "pass"));
        return userDAO.findByIds(1).toString();
    }

}
