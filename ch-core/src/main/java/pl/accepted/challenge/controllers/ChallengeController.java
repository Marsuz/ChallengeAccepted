package pl.accepted.challenge.controllers;

import challenges.FirstWinChallenge;
import challenges.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.persistence.FirstWinRepository;
import pl.accepted.challenge.persistence.UserRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {

    @Autowired
    FirstWinRepository firstWinRepository;

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FirstWinChallenge> getAllChallenges() {

        List<FirstWinChallenge> challenges = (List) firstWinRepository.findAll();
        return challenges;

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public FirstWinChallenge addChallenge(@RequestParam("name") String name, @RequestParam("owner") String username, @RequestParam("deadline") String deadline) {

        User owner = userRepository.findOne(username);
        FirstWinChallenge challenge = firstWinRepository.findOne(name);

        if(challenge != null) return null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime deadlineAsLocalDateTime = LocalDateTime.parse(deadline, formatter);

        challenge = new FirstWinChallenge(name, owner, deadlineAsLocalDateTime);

        return challenge;

    }

    @RequestMapping(value = "/challenge")
    public FirstWinChallenge getChallenge(@RequestParam("name") String name) {

        FirstWinChallenge challenge = firstWinRepository.findOne(name);
        return challenge;

    }

    /*@RequestMapping(value = "challenges/{name}/addparticipant", method = RequestMethod.POST)
    public void addParticipant(@RequestParam("name") String name, @RequestParam("nick") String nick) {

        FirstWinChallenge challenge = firstWinChallengeService.findByName(name);
        User user = userService.findByNick(nick);

        if(challenge == null || user == null) return;

        challenge.addParticipant(user);
        firstWinChallengeService.updateChallenge(challenge);

    }*/

}
