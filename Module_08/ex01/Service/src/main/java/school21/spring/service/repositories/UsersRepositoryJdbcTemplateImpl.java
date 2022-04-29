package school21.spring.service.repositories;

import javax.sql.DataSource;

public class UsersRepositoryJdbcTemplateImpl {
	private final DataSource dataSource;

	public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
