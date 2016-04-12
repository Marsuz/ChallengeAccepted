package model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
public class AssignedToken extends ObjectWithId {

    private final String hashedToken;
    private final LocalDateTime expirationDate;
    @ManyToOne
    private final User assignedUser;
    private boolean isValid = true;

    public AssignedToken(String hashedToken, User assignedUser, LocalDateTime expirationDate) {
        super();
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

    public boolean isValid() {
        return isValid;
    }
}
