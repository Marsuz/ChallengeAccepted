package pl.accepted.challenge.model.challenges;

import com.sun.javafx.beans.IDProperty;
import pl.accepted.challenge.model.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcin on 2016-03-18.
 */

@Entity
public class FirstWinChallenge implements IChallenge {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany
    private List<User> participants;

    private boolean isActive;

    public FirstWinChallenge(String name) {
        this.name = name;
        this.participants = new ArrayList<>();
        this.isActive = true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
