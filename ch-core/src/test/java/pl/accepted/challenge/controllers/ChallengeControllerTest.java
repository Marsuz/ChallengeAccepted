package pl.accepted.challenge.controllers;

import challenges.FirstWinChallenge;
import challenges.User;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import org.aspectj.lang.annotation.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pl.accepted.challenge.services.FirstWinService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.jayway.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;



/**
 * Created by Marcin on 2016-03-25.
 */
public class ChallengeControllerTest {

    @InjectMocks
    private static ChallengeController challengeController = new ChallengeController();

    @Mock
    private FirstWinService firstWinService;

    @BeforeClass
    public static void setUp() {
        RestAssuredMockMvc.standaloneSetup(challengeController);
    }

    @org.junit.Before
    public void beforeMethodSetUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @Ignore
    public void shouldGetAllChallenges() {
        User user = new User("name1", "name1", "surname1", "password1");
        User user1 = new User("name2", "name1", "surname1", "password1");
        FirstWinChallenge challenge1 = new FirstWinChallenge("challenge1", user, LocalDateTime.now());
        challenge1.addParticipant(user);
        challenge1.addParticipant(user1);
        FirstWinChallenge challenge2 = new FirstWinChallenge("challenge2", user1, LocalDateTime.now());
        challenge2.addParticipant(user);
        challenge2.addParticipant(user1);
        List<FirstWinChallenge> listOfAllChallenges = Arrays.asList(challenge1, challenge2);
        when(firstWinService.getAllFirstChallenges()).thenReturn(listOfAllChallenges);

        List<FirstWinChallenge> returnedChallenges = Arrays.asList(given().when().get("/challenges/all").as(FirstWinChallenge[].class));

        assertThat(returnedChallenges).hasSize(2).contains(challenge1).contains(challenge2);
    }


}