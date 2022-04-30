package edu.school21.sockets.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.sockets.repositories.UsersRepositoryJdbcTemplateImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "edu.school21.sockets")
public class SocketsApplicationConfig {
	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	@Value("${db.driver.name}")
	private String driverClassName;

	@Bean
	public HikariDataSource hikariDataSource() {
		HikariDataSource hikariDS = new HikariDataSource();
		hikariDS.setJdbcUrl(url);
		hikariDS.setUsername(user);
		hikariDS.setPassword(password);
		hikariDS.setDriverClassName(driverClassName);

		return new HikariDataSource(hikariDS);
	}

	@Bean
	public UsersRepositoryJdbcTemplateImpl usersRepositoryJdbcTemplateImpl() {
		return new UsersRepositoryJdbcTemplateImpl(hikariDataSource());
	}

	@Bean
	public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }
}
