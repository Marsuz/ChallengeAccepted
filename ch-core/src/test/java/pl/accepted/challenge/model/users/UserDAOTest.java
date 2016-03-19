package pl.accepted.challenge.model.users;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.accepted.challenge.persistence.UserDAO;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * Created by Marcin on 2016-03-19.
 */

//@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {

    //@Autowired
    private static UserDAO userDAO;

    private static User user1;

    private static User user2;

    @BeforeClass
    public static void setUp() throws Exception {

        userDAO = new UserDAO();

        user1 = new User("Marsuz", "Marcin", "Zajda", "pass");

        user2 = new User("ElChomiczur", "Matuesz", "Kmiecik", "pass");

    }

    @Test
    public void shouldDaoPersistAndFindUser() {

        userDAO.updateUsers(user1, user2);

        List<User> usersByFindAll = userDAO.findAll();

        assertThat(usersByFindAll).hasSize(2).contains(user1).contains(user2);

    }

    @Test
    public void shouldDaoPersistAndFindByAllFields() {

        //userDAO.updateUsers(user1, user2);

        User user = userDAO.findByNickAndPass("Marsuz", "pass");

        assertThat(user).isEqualTo(user1);

    }

    @Test
    public void shouldDaoPersistAndFindByNick() {

        User user3 = new User("seyuioa", "Sara", "Sawa", "pass1");

        userDAO.updateUsers(user3);

        User user = userDAO.findByNick(user3.getNick());

        System.out.println(user3);
        assertThat(user).isEqualsToByComparingFields(user3);

    }

}