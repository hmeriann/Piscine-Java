package edu.school21.chat.app;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) throws SQLException {

        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(hikariDataSource);
        checkMessageId(messagesRepository);
        checkException(messagesRepository);
        hikariDataSource.close();
    }

    private static void checkMessageId(MessagesRepository messagesRepository) {
        User creator = new User("test_user", "qweasd");
        User author = creator;
        Chatroom chatroom = new Chatroom("testing room", creator);
        Message message = new Message(author, chatroom, "Can I run some tests here?");

        try {
            messagesRepository.save(message);
            System.out.println(message.getMessageId() + ": " + message.getMessageText());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void checkException(MessagesRepository messagesRepository) {
        User creator = new User("e_user", "eeeeeee");
        User author = creator;
        Chatroom chatroom = new Chatroom("exceptions room", creator);
        Message message = new Message(author, chatroom, "Is there any exceptions?");

        try {
            messagesRepository.save(message);
            System.out.println(message.getMessageId() + ": " + message.getMessageText());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
