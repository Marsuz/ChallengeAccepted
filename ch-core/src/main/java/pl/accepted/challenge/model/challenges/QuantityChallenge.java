package pl.accepted.challenge.model.challenges;

import pl.accepted.challenge.model.users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Marcin on 2016-03-18.
 */

@Entity
public class QuantityChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private boolean isActive;

    private Map<User, Long> results;

    @OneToMany
    private List<User> participants;



    public QuantityChallenge(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
        isActive = true;
        this.results = new HashMap<>();
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void makeWinner(User user) {
        user.incChallengesCounter();
        isActive = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public void setResultForUser(User user, long result) {
        results.put(user, result);
    }
}
