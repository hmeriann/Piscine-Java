package edu.school21.sockets.repositories;

import edu.school21.sockets.models.User;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Optional;

@Component
public interface UsersRepository extends CrudRepository<User> {
	Optional<User> findByLogin(String email);
}
