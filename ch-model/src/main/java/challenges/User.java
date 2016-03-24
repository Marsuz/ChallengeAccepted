package challenges;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class User {

    @Id
    private String username;
    private String name;
    private String surname;
    private String hashedPass;
    private long challengeCounter;

    public User() {
    }

    public User(String username, String name, String surname, String hashedPass) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.hashedPass = hashedPass;
        this.challengeCounter = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "User{" +
                //"id=" + id +
                ", username='" + username + '\'' +
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

        return username.equals(user.username);

    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }

}
