package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class Chatroom {

	private Integer chatroomId;
	private String chatroomName;
	private User chatroomOwner;
	private List<Message> messagesInChatroom;

	public Chatroom(String chatroomName, User chatroomOwner) {
		this.chatroomName = chatroomName;
		this.chatroomOwner = chatroomOwner;
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "Chatroom{" +
				"chatroomId=" + chatroomId +
				", chatroomName='" + chatroomName + '\'' +
				", chatroomOwner='" + chatroomOwner + '\'' +
				", messagesInChatroom=" + messagesInChatroom +
				'}';
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		Chatroom chatroom = (Chatroom) object;
		return chatroomId == chatroom.chatroomId && chatroomName.equals(chatroom.chatroomName) && chatroomOwner.equals(chatroom.chatroomOwner) && messagesInChatroom.equals(chatroom.messagesInChatroom);
	}

	public int hashCode() {
		return Objects.hash(super.hashCode(), chatroomId, chatroomName, chatroomOwner, messagesInChatroom);
	}

	public long getChatroomId() {
		return chatroomId;
	}

	public void setChatroomId(Integer chatroomId) {
		this.chatroomId = chatroomId;
	}

	public String getChatroomName() {
		return chatroomName;
	}

	public void setChatroomName(String chatroomName) {
		this.chatroomName = chatroomName;
	}

	public User getChatroomOwner() {
		return chatroomOwner;
	}

	public void setChatroomOwner(User chatroomOwner) {
		this.chatroomOwner = chatroomOwner;
	}

	public List<Message> getMessagesInChatroom() {
		return messagesInChatroom;
	}

	public void setMessagesInChatroom(List<Message> messagesInChatroom) {
		this.messagesInChatroom = messagesInChatroom;
	}
}
