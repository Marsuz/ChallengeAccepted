package pl.accepted.challenge.model.users;

import org.junit.BeforeClass;
import org.junit.Test;
import pl.accepted.challenge.persistence.UserDAO;
import users.User;

import java.util.List;

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

    }

    @Test
    public void shouldDaoPersistAndFindUser() {

        user1 = new User("Marsuz", "Marcin", "Zajda", "pass");

        user2 = new User("ElChomiczur", "Matuesz", "Kmiecik", "pass");

        userDAO.updateUsers(user1, user2);

        List<User> usersByFindAll = userDAO.findAll();

        System.out.println(usersByFindAll);

        //user1 = userDAO.findByNick("Marsuz");
        user1.setName("Darek");

        userDAO.updateUsers(user1, user2);

        usersByFindAll = userDAO.findAll();

        System.out.println(usersByFindAll);

        //assertThat(usersByFindAll).contains(user1).contains(user2);

    }

    /*@Test
    public void shouldDaoPersistAndFindByAllFields() {

        userDAO.updateUsers(user1, user2);

        User user = userDAO.findByNickAndPass("Marsuz", "pass");

        assertThat(user.getNick()).isEqualTo(user1.getNick());

    }

    @Test
    public void shouldDaoPersistAndFindByNick() {

        User user3 = new User("seyuioa", "Sara", "Sawa", "pass1");

        userDAO.updateUsers(user3);

        User user = userDAO.findByNick(user3.getNick());

        System.out.println(user3);
        assertThat(user.getNick()).isEqualTo(user3.getNick());

    }*/

}