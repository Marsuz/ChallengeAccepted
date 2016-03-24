package pl.accepted.challenge.persistence;

import challenges.FirstWinChallenge;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import users.User;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

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
	@Ignore
	public void shouldDAOPersistAndFindChallenge() {

		User user1 = userDAO.findByNick("Marsuz");
		User user2 = userDAO.findByNick("ElChomiczur");

		//userDAO.updateUsers(user1, user2);

		challenge.addParticipant(user1);
		challenge.addParticipant(user2);
		challenge.setOwner(user1);

		firstWinChallengeDAO.updateChallenge(challenge);

		List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();

		assertThat(challenges).contains(challenge);

	}

	@Test
	@Ignore
	public void shouldDAOPersistAndDeleteChallenge() {

		User user1 = userDAO.findByNick("Marsuz");
		User user2 = userDAO.findByNick("ElChomiczur");

		userDAO.updateUsers(user1, user2);

		challenge.addParticipant(user1);
		challenge.addParticipant(user2);
		challenge.setOwner(user2);

		firstWinChallengeDAO.updateChallenge(challenge);

		challenge.removeParticipant(user1);
		challenge.removeParticipant(user2);

		List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();

		assertThat(challenges).hasSize(0);
	}

}