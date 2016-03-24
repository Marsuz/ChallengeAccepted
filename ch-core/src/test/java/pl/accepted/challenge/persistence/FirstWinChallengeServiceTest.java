//package pl.accepted.challenge.persistence;
//
//import challenges.FirstWinChallenge;
//import org.junit.BeforeClass;
//import org.junit.Ignore;
//import org.junit.Test;
//import challenges.User;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//public class FirstWinChallengeServiceTest {
//
//	private static UserService userService;
//
//	private static FirstWinChallengeService firstWinChallengeService;
//
//	private static FirstWinChallenge challenge;
//
//	@BeforeClass
//	public static void setUp() {
//
//		userService = new UserService();
//		firstWinChallengeService = new FirstWinChallengeService();
//
//		challenge = new FirstWinChallenge("Namow Grabcia na silke");
//
//	}
//
//	@Test
//	@Ignore
//	public void shouldDAOPersistAndFindChallenge() {
//
//		User user1 = userService.findByNick("Marsuz");
//		User user2 = userService.findByNick("ElChomiczur");
//
//		//userDAO.updateUsers(user1, user2);
//
//		challenge.addParticipant(user1);
//		challenge.addParticipant(user2);
//		challenge.setOwner(user1);
//
//		firstWinChallengeService.updateChallenge(challenge);
//
//		List<FirstWinChallenge> challenges = firstWinChallengeService.findAll();
//
//		assertThat(challenges).contains(challenge);
//	}
//
//	@Test
//	@Ignore
//	public void shouldDAOPersistAndDeleteChallenge() {
//
//		User user1 = userService.findByNick("Marsuz");
//		User user2 = userService.findByNick("ElChomiczur");
//
//		userService.updateUsers(user1, user2);
//
//		challenge.addParticipant(user1);
//		challenge.addParticipant(user2);
//		challenge.setOwner(user2);
//
//		firstWinChallengeService.updateChallenge(challenge);
//
//		challenge.removeParticipant(user1);
//		challenge.removeParticipant(user2);
//
//		List<FirstWinChallenge> challenges = firstWinChallengeService.findAll();
//
//		assertThat(challenges).hasSize(0);
//	}
//
//}