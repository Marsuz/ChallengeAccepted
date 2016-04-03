package security;

import challenges.User;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class AssignedToken {

    private final String hashedToken;
    private final LocalDateTime expirationDate;
    @ManyToOne
    private final User assignedUser;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private boolean isValid = true;

    public AssignedToken(String hashedToken, User assignedUser, LocalDateTime expirationDate) {
        this.hashedToken = hashedToken;
        this.assignedUser = assignedUser;
        this.expirationDate = expirationDate;
    }

    public void invalidate() {
        isValid = false;
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public String getHashedToken() {
        return hashedToken;
    }

    public User getAssignedUser() {
        return assignedUser;
    }

    public int getId() {
        return id;
    }

    public boolean isValid() {
        return isValid;
    }
}
