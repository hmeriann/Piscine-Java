package edu.school21.chat.models;

import java.time.LocalDateTime;
import java.util.Objects;

public class Message {
	private static Long prevId = (long)1;
	private Long messageId;
	private User messageAuthor;
	private Chatroom messageRoom;
	private String messageText;
	private LocalDateTime messageDateTime;

	public Message(User messageAuthor, Chatroom messageRoom, String messageText) {
		this.messageId = Message.prevId++;
		this.messageAuthor = messageAuthor;
		this.messageRoom = messageRoom;
		this.messageText = messageText;
		this.messageDateTime = LocalDateTime.now();
	}


	public long getMessageId() {
		return messageId;
	}

	public void setMessageId(Long messageId) {
		this.messageId = messageId;
	}

	public User getMessageAuthor() {
		return messageAuthor;
	}

	public void setMessageAuthor(User messageAuthor) {
		this.messageAuthor = messageAuthor;
	}

	public Chatroom getMessageRoom() {
		return messageRoom;
	}

	public void setMessageRoom(Chatroom messageRoom) {
		this.messageRoom = messageRoom;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public LocalDateTime getMessageDateTime() {
		return messageDateTime;
	}

	public void setMessageDateTime(LocalDateTime messageDateTime) {
		this.messageDateTime = messageDateTime;
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Message message = (Message) object;
		return messageId == message.messageId && messageAuthor.equals(message.messageAuthor) && messageRoom.equals(message.messageRoom) && messageText.equals(message.messageText) && messageDateTime.equals(message.messageDateTime);
	}

	public int hashCode() {
		return Objects.hash(super.hashCode(), messageId, messageAuthor, messageRoom, messageText, messageDateTime);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Message{" +
				"messageId=" + messageId +
				", messageAuthor=" + messageAuthor +
				", messageRoom=" + messageRoom +
				", messageText='" + messageText + '\'' +
				", messageDateTime=" + messageDateTime +
				'}';
	}
}
