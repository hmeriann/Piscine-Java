package edu.school21.sockets.services;

import edu.school21.sockets.models.User;
import edu.school21.sockets.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UsersServiceImpl implements UsersService {
	private UsersRepository usersRepository;
	private PasswordEncoder passwordEncoder;

	@Autowired
	public UsersServiceImpl(@Qualifier("usersRepositoryJdbcTemplateImpl")UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@Autowired
	public void setEncodedPassword(@Qualifier("passwordEncoder")PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	public boolean signUp(String login, String password) {
		Optional<User> tmp = usersRepository.findByLogin(login);
		if (!tmp.isPresent()) {
			usersRepository.save(new User(login, passwordEncoder.encode(password)));
			return true;
		}
		return false;
	}
}
