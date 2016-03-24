package pl.accepted.challenge.controllers;

import challenges.FirstWinChallenge;
import challenges.User;
import exceptions.UserNotFoundException;
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

    @RequestMapping(value = "/{name}")
    public FirstWinChallenge getChallenge(@RequestParam("name") String name) {

        FirstWinChallenge challenge = firstWinRepository.findOne(name);
        return challenge;

    }

    @RequestMapping(value = "/{name}/add", method = RequestMethod.POST)
    public void addParticipanToChallenge(@RequestParam("name") String name, @RequestParam("username") String participant) throws UserNotFoundException {

        FirstWinChallenge challenge = firstWinRepository.findOne(name);
        User user = userRepository.findOne(participant);

        if(challenge == null || user == null) throw new UserNotFoundException();

        challenge.addParticipant(user);
        firstWinRepository.save(challenge);

    }

}
