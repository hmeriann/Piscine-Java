package school21.spring.service.repositories;

import com.zaxxer.hikari.HikariDataSource;
import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

	private final DataSource dataSource;

	UsersRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Optional findById(Long id) {
		return Optional.empty();
	}

	@Override
	public List findAll() throws SQLException {
		List<User> userList = new ArrayList<>();
		try {
			Connection connection = dataSource.getConnection();
			System.out.println(connection);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from users");
		} catch (SQLException e) {
			e.printStackTrace();
		}


		return null;
	}

	@Override
	public void save(Object entity) {

	}

	@Override
	public void update(Object entity) {

	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public Optional findByEmail(String email) {
		return Optional.empty();
	}
}
