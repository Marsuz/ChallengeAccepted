package pl.accepted.challenge.services;

import challenges.FirstWinChallenge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.accepted.challenge.persistence.FirstWinRepository;

import java.util.List;

/**
 * Created by Marcin on 2016-03-25.
 */

@Service
public class FirstWinService {

    @Autowired
    FirstWinRepository firstWinRepository;

    public List<FirstWinChallenge> getAllFirstChallenges() {
        return (List) firstWinRepository.findAll();
    }

    public void createOrUpdate(FirstWinChallenge challenge) {
        firstWinRepository.save(challenge);
    }

    public FirstWinChallenge getFirstWinChallengeByName(String name) {
        return firstWinRepository.findOne(name);
    }

    public void deleteFirstWinChallenge(FirstWinChallenge challenge) {
        firstWinRepository.delete(challenge);
    }
}