package pl.accepted.challenge.persistence;

import org.junit.BeforeClass;
import org.junit.Test;
import pl.accepted.challenge.model.challenges.FirstWinChallenge;
import pl.accepted.challenge.model.users.User;
import static org.assertj.core.api.Assertions.*;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Marcin on 2016-03-19.
 */
public class FirstWinChallengeDAOTest {

    private static UserDAO userDAO;

    private static FirstWinChallengeDAO firstWinChallengeDAO;

    private static FirstWinChallenge challenge;

    @BeforeClass
    public static void setUp() {

        userDAO = new UserDAO();
        firstWinChallengeDAO = new FirstWinChallengeDAO();

        challenge = new FirstWinChallenge("Namow Grabcia na silke");

    }

    @Test
    public void shouldDAOPersistAndFindChallenge() {

        User user1 = new User("Marcin", "Zajda", "pass");
        User user2 = new User("Matuesz", "Kmiecik", "pass");

        userDAO.updateUsers(user1, user2);

        challenge.addParticipant(user1);
        challenge.addParticipant(user2);
        challenge.setOwner(user1);

        firstWinChallengeDAO.updateChallenge(challenge);

        List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();

        assertThat(challenges).hasSize(1).contains(challenge);

    }

    @Test
    public void shouldDAOPersistAndDeleteChallenge() {

        User user1 = new User("Marcin", "Zajda", "pass");
        User user2 = new User("Matuesz", "Kmiecik", "pass");

        userDAO.updateUsers(user1, user2);

        challenge.addParticipant(user1);
        challenge.addParticipant(user2);
        challenge.setOwner(user2);

        firstWinChallengeDAO.updateChallenge(challenge);

        firstWinChallengeDAO.removeByIds(challenge.getId());

        challenge.removeParticipant(user1);
        challenge.removeParticipant(user2);

        List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();

        assertThat(challenges).hasSize(0);
    }

}