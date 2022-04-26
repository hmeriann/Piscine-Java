package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long messageId) throws SQLException {
        Optional<Message> optionalMessage;

        Connection connection = dataSource.getConnection();

        Statement statement = connection.createStatement();
        String query = "SELECT * FROM chat.message WHERE messageId = " + messageId;
        ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();

        User user = new User("hmeriann", "123");
        Chatroom chatroom = new Chatroom("flood", user);
        optionalMessage = Optional.of(new Message(resultSet.getInt("messageId"), user, chatroom, resultSet.getString("message"), LocalDateTime.now()));

        if (optionalMessage == null)
            return Optional.empty();
        return optionalMessage;
    }
}
