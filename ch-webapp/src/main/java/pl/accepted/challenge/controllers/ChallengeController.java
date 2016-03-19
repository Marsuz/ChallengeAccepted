package pl.accepted.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.accepted.challenge.model.challenges.FirstWinChallenge;
import pl.accepted.challenge.persistence.FirstWinChallengeDAO;

import java.util.List;

/**
 * Created by Marcin on 2016-03-19.
 */

@RestController
public class ChallengeController {

    @Autowired
    FirstWinChallengeDAO firstWinChallengeDAO;

    @RequestMapping(value = "challenges/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<FirstWinChallenge>> getAllChallenges() {

        List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();
        return new ResponseEntity<List<FirstWinChallenge>>(challenges, HttpStatus.OK);

    }

}
