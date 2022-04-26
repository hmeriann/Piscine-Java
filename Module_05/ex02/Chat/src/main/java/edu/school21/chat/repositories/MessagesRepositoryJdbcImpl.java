package edu.school21.chat.repositories;

import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {

    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Optional<Message> findById(Long messageId) throws SQLException {
        Optional<Message> optionalMessage;
        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM chat.message WHERE chat.message.massage_id = " + messageId;
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next())
                return Optional.empty();

            optionalMessage = Optional.of(new Message(
                    getMessageAuthor(connection, resultSet.getLong(2)),
                    getMessageChatRoom(connection, resultSet.getLong(3)),
                    resultSet.getString(4)));

            if (optionalMessage == null)
                return Optional.empty();
            return optionalMessage;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private User getMessageAuthor(Connection connection, Long userId) {
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT chat.users.login, chat.users.password FROM chat.users WHERE user_id = " + userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() == false)
                return null;
            String login = resultSet.getString(1);
            String password = resultSet.getString(2);
            user = new User(login,password);
            user.setUserId(userId);
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    private Chatroom getMessageChatRoom(Connection connection, Long roomId) {
        Chatroom chatroom = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT chatroom_name FROM chat.chatroom WHERE chatroom_id = " + roomId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() == false)
                return null;
            String name = resultSet.getString(1);
            chatroom = new Chatroom(name, null);
            chatroom.setChatroomId(roomId);
            resultSet.close();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return chatroom;
    }

    @Override
    public void save(Message message) {
        Connection connection;
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        if (message == null)
            return;
        String statement = "INSERT INTO chat.message(message_author, message_room, message_text, message_date_time) VALUES ('" +
                + message.getMessageAuthor().getUserId() + "', '"
                + message.getMessageRoom().getChatroomId() + "', '"
                + message.getMessageText() + "', '"
                + message.getMessageDateTime() + "') RETURNING message.massage_id";
        try {
            connection = this.dataSource.getConnection();
            isUserIdExists(message.getMessageAuthor().getUserId(), connection);
            isRoomIdExists(message.getMessageRoom().getChatroomId(), connection);

            preparedStatement = connection.prepareStatement(statement);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();

            message.setMessageId(resultSet.getLong(1));
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NotSavedSubEntityException e) {
            throw new RuntimeException(e);
        }
    }

    private void isRoomIdExists(Long roomId, Connection connection) throws SQLException, NotSavedSubEntityException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT chatroom.chatroom_id FROM chat.chatroom WHERE chatroom.chatroom_id = " + roomId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next() == false) {
            resultSet.close();
            preparedStatement.close();
            throw new NotSavedSubEntityException("ID = " + roomId + " is failed to be saved into CHATROOM table");
        }
        resultSet.close();
        preparedStatement.close();
    }

    private void isUserIdExists(Long userId, Connection connection) throws SQLException, NotSavedSubEntityException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT user_id FROM chat.users WHERE user_id = " + userId);

        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.next() == false) {
            resultSet.close();
            preparedStatement.close();
            throw new NotSavedSubEntityException("ID = " + userId + " is failed to be saved into USERS table");
        }
        resultSet.close();
        preparedStatement.close();
    }

    private class NotSavedSubEntityException extends Throwable {
        public NotSavedSubEntityException(String s) {
            super(s);
        }
    }
}
