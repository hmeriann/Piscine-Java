package school21.spring.service.repositories;

import school21.spring.service.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

	private DataSource dataSource;

	UsersRepositoryJdbcImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public Optional<User> findById(Long id) throws SQLException {

		Connection connection = dataSource.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from users where id = " + id);
		if (!resultSet.next())
			throw new RuntimeException("No users with such id" + id);
		User user = new User(resultSet.getLong(1), resultSet.getString(2));
		statement.close();
		connection.close();
		return Optional.of(user);
	}

	@Override
	public List<User> findAll() {
		List<User> userList = new ArrayList<>();
		try {
			Connection connection = dataSource.getConnection();
			Statement statement = connection.createStatement();

			ResultSet resultSet = statement.executeQuery("select * from users");
			while (resultSet.next()) {
				userList.add(new User(resultSet.getLong(1), resultSet.getString(2)));
			}
			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;
	}

	@Override
	public void save(User user) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatementstatement = connection.prepareStatement("insert into users(email) values (?)");

		preparedStatementstatement.setString(1, user.getEmail());
		preparedStatementstatement.execute();
		preparedStatementstatement.close();
		connection.close();
	}

	@Override
	public void update(User user) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatementstatement = connection.prepareStatement("update users set email = ? where id = " + user.getId());

		preparedStatementstatement.setString(1, user.getEmail());
		preparedStatementstatement.execute();
		preparedStatementstatement.close();
		connection.close();
	}

	@Override
	public void delete(Long id) throws SQLException {
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatementstatement = connection.prepareStatement("delete from users where id = " + id);

		preparedStatementstatement.execute();
		preparedStatementstatement.close();
		connection.close();
	}

	@Override
	public Optional<User> findByEmail(String email) throws SQLException {
		User user = null;
		Connection connection = dataSource.getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ?;");
		preparedStatement.setString(1, email);
		ResultSet resultSet = preparedStatement.executeQuery();
		if (!resultSet.next())
			throw new RuntimeException("No users with such email" + email);
		user = new User(resultSet.getLong(1), resultSet.getString(2));
		preparedStatement.close();
		connection.close();
		return Optional.of(user);
	}
}
