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

@Entity(name="msgs")
public class Msg {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private Long id;

    @Column(length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    @JsonIgnore
    private User sender;
    
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    @JsonIgnore
    private User receiver;
    
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@PrePersist
	private void onCreate() {
	    timestamp = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReciever(User receiver) {
		this.receiver = receiver;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	@Override
	public String toString() {
		return "Msg [id=" + id + ", content=" + content + ", sender=" + sender + ", receiver=" + receiver
				+ ", timestamp=" + timestamp + "]";
	}
	
}
