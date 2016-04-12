package pl.accepted.challenge.persistence;

import model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);

    User findByUsernameAndPassword(String username, String password);

    User findById(long id);

    User deleteById(long id);

}
