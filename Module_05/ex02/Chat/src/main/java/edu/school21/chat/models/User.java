package edu.school21.chat.models;

import java.util.List;
import java.util.Objects;

public class User {
	private static Long prevId = (long)1;
	private Long userId;
	private String login;
	private String password;
	private List<Chatroom> createdRooms;
	private List<Chatroom> usersChatrooms;

	public User(String login, String password) {
		this.userId = User.prevId++;
		this.login = login;
		this.password = password;
	}

	public User(Long userId, String login, String password, List<Chatroom> createdRooms, List<Chatroom> usersChatrooms) {
		this.userId = userId;
		this.login = login;
		this.password = password;
		this.createdRooms = createdRooms;
		this.usersChatrooms = usersChatrooms;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean equals(Object object) {
		if (this == object) return true;
		if (object == null || getClass() != object.getClass()) return false;
		if (!super.equals(object)) return false;
		User user = (User) object;
		return userId == user.userId && login.equals(user.login) && password.equals(user.password) && createdRooms.equals(user.createdRooms) && usersChatrooms.equals(user.usersChatrooms);
	}

	public int hashCode() {
		return Objects.hash(super.hashCode(), userId, login, password, createdRooms, usersChatrooms);
	}

	@java.lang.Override
	public java.lang.String toString() {
		return "User{" +
				"userId=" + userId +
				", login='" + login + '\'' +
				", password='" + password + '\'' +
				", createdRooms=" + createdRooms +
				", usersChatrooms=" + usersChatrooms +
				'}';
	}

	public List<Chatroom> getCreatedRooms() {
		return createdRooms;
	}

	public void setCreatedRooms(List<Chatroom> createdRooms) {
		this.createdRooms = createdRooms;
	}

	public List<Chatroom> getUsersChatrooms() {
		return usersChatrooms;
	}

	public void setUsersChatrooms(List<Chatroom> usersChatrooms) {
		this.usersChatrooms = usersChatrooms;
	}
}
