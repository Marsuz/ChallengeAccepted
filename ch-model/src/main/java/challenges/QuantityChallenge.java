package challenges;

import users.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
public class QuantityChallenge {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String name;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User owner;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User winner;

	@Column
	private boolean isActive;

	private Map<User, Long> results;

	@OneToMany
	private List<User> participants;

	public QuantityChallenge(String name) {
		this.name = name;
		this.participants = new ArrayList<>();
		isActive = true;
		this.results = new HashMap<>();
	}

	public void addParticipant(User user) {
		participants.add(user);
	}

	public void makeWinner(User user) {
		winner = user;
		user.incChallengesCounter();
		isActive = false;
	}

	public void setResultForUser(User user, long result) {

		results.put(user, result);

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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean active) {
		isActive = active;
	}

	public Map<User, Long> getResults() {
		return results;
	}

	public void setResults(Map<User, Long> results) {
		this.results = results;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
}
