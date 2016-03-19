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
public class FirstWinChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private User winner;

    @OneToMany
    private List<User> participants;

    private boolean isActive;

    public FirstWinChallenge() {}

    public FirstWinChallenge(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
        this.isActive = true;
    }

    public void makeWinner(User user) {
        winner = user;
        user.incChallengesCounter();
        isActive = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getWinner() {
        return winner;
    }

    public void setWinner(User winner) {
        this.winner = winner;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
