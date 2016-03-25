package pl.accepted.challenge.controllers;

import challenges.FirstWinChallenge;
import challenges.User;
import pl.accepted.challenge.exceptions.ChallengeAlreadyExistsException;
import pl.accepted.challenge.exceptions.ChallengeNotFoundException;
import pl.accepted.challenge.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.accepted.challenge.service.FirstWinService;
import pl.accepted.challenge.service.UsersService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/challenges")
public class ChallengeController {

    @Autowired
    FirstWinService firstWinService;

    @Autowired
    UsersService usersService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<FirstWinChallenge> getAllChallenges() {

        return firstWinService.getAllFirstChallenges();

    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public FirstWinChallenge addChallenge(@RequestParam("name") String name, @RequestParam("deadline") String deadline, @RequestBody User user) throws ChallengeAlreadyExistsException{

        FirstWinChallenge challenge = firstWinService.getFirstWinChallengeByName(name);

        if(challenge != null)  throw new ChallengeAlreadyExistsException();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime deadlineAsLocalDateTime = LocalDateTime.parse(deadline, formatter);

        challenge = new FirstWinChallenge(name, user, deadlineAsLocalDateTime);
        firstWinService.createOrUpdate(challenge);

        return challenge;

    }

    @RequestMapping(value = "/{name}")
    public FirstWinChallenge getChallenge(@RequestParam("name") String name) {

        return firstWinService.getFirstWinChallengeByName(name);

    }

    @RequestMapping(value = "/{name}/add", method = RequestMethod.POST)
    public void addParticipantToChallenge(@RequestParam("name") String name, @RequestParam("username") String participant) throws UserNotFoundException, ChallengeNotFoundException {

        FirstWinChallenge challenge = firstWinService.getFirstWinChallengeByName(name);

        if(challenge == null) throw new ChallengeNotFoundException();

        User user = usersService.getUserByName(participant);

        if(user == null) throw new UserNotFoundException();

        challenge.addParticipant(user);
        firstWinService.createOrUpdate(challenge);

    }

    @RequestMapping(value = "/{name}/finish}", method = RequestMethod.POST)
    public void finishChallenge(@RequestParam("name") String name, @RequestParam("username") String winner) throws UserNotFoundException, ChallengeNotFoundException {

        FirstWinChallenge challenge = firstWinService.getFirstWinChallengeByName(name);

        if(challenge == null) throw new ChallengeNotFoundException();

        User user = usersService.getUserByName(winner);

        if(user == null) throw new UserNotFoundException();

        challenge.finishChallenge(user);

        firstWinService.createOrUpdate(challenge);

    }


}
