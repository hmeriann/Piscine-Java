package edu.school21.sockets.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import edu.school21.sockets.models.User;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
	private final JdbcTemplate jdbcTemplate;

	public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<User> UserMapper = ((rs, rowNum) -> {
		return new User(rs.getLong(1), rs.getString(2), rs.getString(3));
	});

	@Override
	public Optional<User> findById(Long id) {

		List<User> userList = jdbcTemplate.query("select * from users where id = ?", UserMapper, id);
		if (userList.isEmpty())
			return Optional.empty();
		else
			return Optional.of(userList.get(0));
	}

	@Override
	public Optional<User> findByLogin(String login){

		List<User> userList = jdbcTemplate.query("select * from users where login= ?;", UserMapper, login);
		if (userList.isEmpty())
			return Optional.empty();
		else
			return Optional.of(userList.get(0));
	}

	@Override
	public List<User> findAll() {
		return jdbcTemplate.query("select * from users", UserMapper);
	}

	@Override
	public void save(User user){
		jdbcTemplate.update("insert into users(login, password) values (?, ?)", user.getLogin(), user.getPassword());
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update("update users set login = ?, password = ? where id = ?", user.getLogin(), user.getPassword(), user.getId());
	}

	@Override
	public void delete(Long id) {
		jdbcTemplate.update("delete from users where id = ?", id);
	}

}
