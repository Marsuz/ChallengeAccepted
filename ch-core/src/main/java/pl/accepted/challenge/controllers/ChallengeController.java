package pl.accepted.challenge.controllers;

import challenges.FirstWinChallenge;
import challenges.User;
import exceptions.ChallengeAlreadyExistsException;
import exceptions.ChallengeNotFoundException;
import exceptions.UserAlreadyExistsException;
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

        return (List) firstWinRepository.findAll();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public FirstWinChallenge addChallenge(@RequestParam("name") String name, @RequestParam("deadline") String deadline, @RequestBody User user) throws ChallengeAlreadyExistsException{

        FirstWinChallenge challenge = firstWinRepository.findOne(name);

        if(challenge != null)  throw new ChallengeAlreadyExistsException();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime deadlineAsLocalDateTime = LocalDateTime.parse(deadline, formatter);

        challenge = new FirstWinChallenge(name, user, deadlineAsLocalDateTime);
        firstWinRepository.save(challenge);

        return challenge;

    }

    @RequestMapping(value = "/{name}")
    public FirstWinChallenge getChallenge(@RequestParam("name") String name) {

        FirstWinChallenge challenge = firstWinRepository.findOne(name);
        return challenge;

    }

    @RequestMapping(value = "/{name}/add", method = RequestMethod.POST)
    public void addParticipantToChallenge(@RequestParam("name") String name, @RequestParam("username") String participant) throws UserNotFoundException, ChallengeNotFoundException {

        FirstWinChallenge challenge = firstWinRepository.findOne(name);

        if(challenge == null) throw new ChallengeNotFoundException();

        User user = userRepository.findOne(participant);

        if(user == null) throw new UserNotFoundException();

        challenge.addParticipant(user);
        firstWinRepository.save(challenge);

    }

    @RequestMapping(value = "/{name}/finish}", method = RequestMethod.POST)
    public void finishChallenge(@RequestParam("name") String name, @RequestParam("username") String winner) throws UserNotFoundException, ChallengeNotFoundException {

        FirstWinChallenge challenge = firstWinRepository.findOne(name);

        if(challenge == null) throw new ChallengeNotFoundException();

        User user = userRepository.findOne(winner );

        if(user == null) throw new UserNotFoundException();

        challenge.finishChallenge(user);

        firstWinRepository.save(challenge);

    }

}
