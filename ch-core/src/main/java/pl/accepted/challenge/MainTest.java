package pl.accepted.challenge;

import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.HibernateUtils;
import pl.accepted.challenge.persistence.UserDAO;

import java.util.List;

/**
 * Created by Marcin on 2016-03-19.
 */
public class MainTest {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();

        User user = new User("Marcin", "Zajda", "pass");

        userDAO.updateUsers(user);

        List<User> users = userDAO.findByIds(1);

        for(User x : users) {
            System.out.println(x);
        }

        HibernateUtils.shutdown();
    }
}
