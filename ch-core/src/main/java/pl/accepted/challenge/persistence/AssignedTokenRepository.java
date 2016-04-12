package pl.accepted.challenge.persistence;

import model.AssignedToken;
import org.springframework.data.repository.CrudRepository;

public interface AssignedTokenRepository extends CrudRepository<AssignedToken, Integer> {

}
