package pl.accepted.challenge.model.users;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Marcin on 2016-03-18.
 */

@Entity
@Table(name="user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String hashedPass;

    @Column
    private long challengeCounter;

    public User() {}

    public User(String name, String surname, String hashedPass) {
        this.name = name;
        this.surname = surname;
        this.hashedPass = hashedPass;
        this.challengeCounter = 0;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getHashedPass() {
        return hashedPass;
    }

    public void setHashedPass(String hashedPass) {
        this.hashedPass = hashedPass;
    }

    public long getChallengeCounter() {
        return challengeCounter;
    }

    public void setChallengeCounter(long challengeCounter) {
        this.challengeCounter = challengeCounter;
    }

    public void incChallengesCounter() {
        challengeCounter++;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", challengeCounter=" + challengeCounter +
                '}';
    }
}
