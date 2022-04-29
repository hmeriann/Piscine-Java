package school21.spring.service.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import school21.spring.service.models.User;
import school21.spring.service.repositories.UsersRepository;

import java.sql.SQLException;

public class Main   {
	public static void main(String[] args) throws SQLException {

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
		System.out.println(usersRepository.findAll());
		System.out.println(usersRepository.findById(4L));

		User newUser = new User("maymay@mail.ru");

		usersRepository.save(newUser);
		System.out.println(usersRepository.findAll());
		usersRepository.update(newUser);
		System.out.println(usersRepository.findAll());
		usersRepository.delete(9L);
		System.out.println(usersRepository.findAll());
		System.out.println(usersRepository.findByEmail("maymay@mail.ru"));

//		usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
//		System.out.println(usersRepository.findAll());

	}




}
