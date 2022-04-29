package school21.spring.service.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {
	private final JdbcTemplate jdbcTemplate;

	public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private RowMapper<User> UserMapper = ((rs, rowNum) -> {
		return new User(rs.getLong(1), rs.getString(2));
	});

	@Override
	public Optional<User> findById(Long id) throws SQLException {

		List<User> userList = jdbcTemplate.query("select * from users where id = ?", UserMapper, id);
		if (userList.isEmpty())
			return Optional.empty();
		else
			return Optional.of(userList.get(0));
	}

	@Override
	public Optional<User> findByEmail(String email) throws SQLException {

		List<User> userList = jdbcTemplate.query("select * from users where email = ?;", UserMapper, email);
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
	public void save(User user) throws SQLException {
		jdbcTemplate.update("insert into users(email) values (?)", user.getEmail());
	}

	@Override
	public void update(User user) throws SQLException {
		jdbcTemplate.update("update users set email = ? where id = ?", user.getEmail(), user.getId());
	}

	@Override
	public void delete(Long id) throws SQLException {
		jdbcTemplate.update("delete from users where id = ?", id);
	}

}
