package users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private String nick;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String hashedPass;

    @Column
    private long challengeCounter;

    public User() {}

    public User(String nick, String name, String surname, String hashedPass) {
        /*this.id = UserDAO.getNextId();*/
        this.nick = nick;
        this.name = name;
        this.surname = surname;
        this.hashedPass = hashedPass;
        this.challengeCounter = 0;
    }

    /*public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }*/

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
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
                //"id=" + id +
                ", nick='" + nick + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", hashedPass='" + hashedPass + '\'' +
                ", challengeCounter=" + challengeCounter +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return nick.equals(user.nick);

    }

    @Override
    public int hashCode() {
        return nick.hashCode();
    }
}
