package challenges;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class FirstWinChallenge {

	@Id
	private String name;

	@ManyToOne
	@JoinColumn(name = "owner_ide")
	private User owner;

	@ManyToOne
	@JoinColumn(name = "winner_id")
	private User winner;

	private LocalDateTime deadline;

	@OneToMany
	private List<User> participants;

	private boolean isActive;

	public FirstWinChallenge() {
	}

	public FirstWinChallenge(String name, User owner, User winner, LocalDateTime deadline) {
		this.name = name;
		this.owner = owner;
		this.winner = winner;
		this.deadline = deadline;
		participants = new ArrayList<>();
		isActive = true;
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

	public LocalDateTime getDeadline() {
		return deadline;
	}

	public void setDeadline(LocalDateTime deadline) {
		this.deadline = deadline;
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

	public void finishChallenge(User user) {
		winner = user;
		user.setChallengeCounter(user.getChallengeCounter() + 1);
		isActive = false;
	}

	public void addParticipant(User user) {
		participants.add(user);
	}

	public void removeParticipant(User user) {

		if (participants.contains(user)) {
			participants.remove(user);
		}

	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		FirstWinChallenge challenge = (FirstWinChallenge) o;

		return name.equals(challenge.name);

	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}
}
