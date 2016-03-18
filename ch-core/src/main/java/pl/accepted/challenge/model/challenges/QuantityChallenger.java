package pl.accepted.challenge.model.challenges;

import pl.accepted.challenge.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Marcin on 2016-03-18.
 */

@Entity
public class QuantityChallenger implements IChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private boolean isActive;

    @OneToMany
    private List<User> participants;

    public QuantityChallenger(List<User> participants) {
        this.participants = new ArrayList<>();
    }

    public void addParticipant(User user) {
        participants.add(user);
    }

    public void makeWinner(User user) {
        user.incChallengesCounter();
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
}
