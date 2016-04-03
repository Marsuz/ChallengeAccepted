package pl.accepted.challenge.persistence;

import org.springframework.data.repository.CrudRepository;
import security.AssignedToken;

public interface AssignedTokenRepository extends CrudRepository<AssignedToken, Integer> {

}
