package com.restapi.onlinechat.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name="chats")
public class Chat {

	@Id
	@GeneratedValue
	@Column(name="chat_id")
	private long id;
	
	@Column(name="user_id")
	@ManyToOne
	private User user;

	@ManyToMany
	private Set<User> contacts = new HashSet<>();
	
	@OneToMany
	private List<Message> messages = new ArrayList<>();
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<User> getContacts() {
		return contacts;
	}

	public void setContacts(Set<User> contacts) {
		this.contacts = contacts;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + ", user=" + user + ", contacts=" + contacts + ", messages=" + messages + "]";
	}
	
	
}
