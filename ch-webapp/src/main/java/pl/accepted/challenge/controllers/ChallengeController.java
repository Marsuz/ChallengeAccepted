package pl.accepted.challenge.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.model.challenges.FirstWinChallenge;
import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.FirstWinChallengeDAO;
import pl.accepted.challenge.persistence.UserDAO;

import java.util.List;

/**
 * Created by Marcin on 2016-03-19.
 */

@RestController
public class ChallengeController {

    @Autowired
    FirstWinChallengeDAO firstWinChallengeDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "challenges/all", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<List<FirstWinChallenge>> getAllChallenges() {

        List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();
        return new ResponseEntity<List<FirstWinChallenge>>(challenges, HttpStatus.OK);

    }

    @RequestMapping(value = "challenges/add", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<FirstWinChallenge> addChallenge(@RequestParam("name") String name, @RequestParam("user") String user) {

        User owner = userDAO.findByNick(user);
        if(owner == null) return new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);

    }

}
