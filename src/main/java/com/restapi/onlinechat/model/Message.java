package com.restapi.onlinechat.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name="messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "contact_id")
    @JsonIgnore
    private Contact contact;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@PrePersist
	private void onCreate() {
	    timestamp = new Date();
	}

	public Long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", contact=" + contact + ", timestamp=" + timestamp + "]";
	}

}
