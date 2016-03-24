//package pl.accepted.challenge.controllers;
//
//import challenges.FirstWinChallenge;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import pl.accepted.challenge.persistence.FirstWinChallengeService;
//import pl.accepted.challenge.persistence.UserService;
//import users.User;
//
//import java.util.List;
//
//@RestController
//public class ChallengeController {
//
//    @Autowired
//    FirstWinChallengeService firstWinChallengeService;
//
//    @Autowired
//    UserService userService;
//
//    @RequestMapping(value = "challenges/all", method = RequestMethod.GET)
//    @ResponseBody
//    public List<FirstWinChallenge> getAllChallenges() {
//
//        List<FirstWinChallenge> challenges = firstWinChallengeService.findAll();
//        return challenges;
//
//    }
//
//    @RequestMapping(value = "challenges/add", method = RequestMethod.POST)
//    @ResponseBody
//    public FirstWinChallenge addChallenge(@RequestParam("name") String name, @RequestParam("user") String user) {
//
//        User owner = userService.findByNick(user);
//        //if(owner == null) return new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);
//        FirstWinChallenge challenge = firstWinChallengeService.findByName(name);
//
//        //if(challenge != null) return new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);
//        if(challenge != null) return null;
//
//        challenge = new FirstWinChallenge(name);
//        challenge.setOwner(owner);
//
//        firstWinChallengeService.updateChallenge(challenge);
//
//        return challenge;
//        //challenge = firstWinChallengeDAO.findByName(name);
//        //return new ResponseEntity<FirstWinChallenge>(challenge, HttpStatus.OK);
//
//    }
//
//    @RequestMapping(value = "challenges/{name}", method = RequestMethod.GET)
//    @ResponseBody
//    public FirstWinChallenge getChallenge(@RequestParam("name") String name) {
//
//        FirstWinChallenge challenge = firstWinChallengeService.findByName(name);
//
//        return challenge; //new ResponseEntity<FirstWinChallenge>(null, null, HttpStatus.BAD_REQUEST);
//        //return null;
//
//    }
//
//    @RequestMapping(value = "challenges/{name}/addparticipant", method = RequestMethod.POST)
//    @ResponseBody
//    public void addParticipant(@RequestParam("name") String name, @RequestParam("nick") String nick) {
//
//        FirstWinChallenge challenge = firstWinChallengeService.findByName(name);
//        User user = userService.findByNick(nick);
//
//        if(challenge == null || user == null) return;
//
//        challenge.addParticipant(user);
//        firstWinChallengeService.updateChallenge(challenge);
//
//    }
//
//}
