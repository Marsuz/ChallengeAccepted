package pl.accepted.challenge.model.challenges;

import pl.accepted.challenge.model.users.User;
import pl.accepted.challenge.persistence.FirstWinChallengeDAO;

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

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private User owner;

    @ManyToOne
    @JoinColumn(name="winner_id")
    private User winner;

    @OneToMany
    private List<User> participants;

    private boolean isActive;

    public FirstWinChallenge() {}

    public FirstWinChallenge(String name) {
        //this.id = FirstWinChallengeDAO.getNextId();
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

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
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

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void removeParticipant(User user) {

        if(participants.contains(user)) {
            participants.remove(user);
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FirstWinChallenge challenge = (FirstWinChallenge) o;

        if (id != challenge.id) return false;
        return name.equals(challenge.name);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + name.hashCode();
        return result;
    }
}
