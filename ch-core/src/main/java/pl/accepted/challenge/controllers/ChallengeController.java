package pl.accepted.challenge.controllers;

import challenges.FirstWinChallenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.persistence.FirstWinChallengeDAO;
import pl.accepted.challenge.persistence.UserDAO;
import users.User;

import java.util.List;

@RestController
public class ChallengeController {

    @Autowired
    FirstWinChallengeDAO firstWinChallengeDAO;

    @Autowired
    UserDAO userDAO;

    @RequestMapping(value = "challenges/all", method = RequestMethod.GET)
    @ResponseBody
    public List<FirstWinChallenge> getAllChallenges() {

        List<FirstWinChallenge> challenges = firstWinChallengeDAO.findAll();
        return challenges;

    }

    @RequestMapping(value = "challenges/add", method = RequestMethod.POST)
    @ResponseBody
    public FirstWinChallenge addChallenge(@RequestParam("name") String name, @RequestParam("user") String user) {

        User owner = userDAO.findByNick(user);
        //if(owner == null) return new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);
        FirstWinChallenge challenge = firstWinChallengeDAO.findByName(name);

        //if(challenge != null) return new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);
        if(challenge != null) return null;

        challenge = new FirstWinChallenge(name);
        challenge.setOwner(owner);

        firstWinChallengeDAO.updateChallenge(challenge);

        return challenge;
        //challenge = firstWinChallengeDAO.findByName(name);
        //return new ResponseEntity<FirstWinChallenge>(challenge, HttpStatus.OK);

    }

    @RequestMapping(value = "challenges/{name}", method = RequestMethod.GET)
    @ResponseBody
    public FirstWinChallenge getChallenge(@RequestParam("name") String name) {

        FirstWinChallenge challenge = firstWinChallengeDAO.findByName(name);

        return challenge; //new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);
        //return null;

    }

    @RequestMapping(value = "challenges/{name}/addparticipant", method = RequestMethod.POST)
    @ResponseBody
    public void addParticipant(@RequestParam("name") String name, @RequestParam("nick") String nick) {

        FirstWinChallenge challenge = firstWinChallengeDAO.findByName(name);
        User user = userDAO.findByNick(nick);

        if(challenge == null || user == null) return;

        challenge.addParticipant(user);
        firstWinChallengeDAO.updateChallenge(challenge);

    }

}
