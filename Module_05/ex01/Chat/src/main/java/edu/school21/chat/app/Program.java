package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();

        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        hikariDataSource.setUsername("username");
        hikariDataSource.setPassword("0");

        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter a message Id");
        System.out.print("\t>");
        System.out.println(messagesRepository.findById(scanner.nextLong()).get());
    }
}
