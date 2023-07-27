package com.restapi.onlinechat.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "CONTACTS")
public class Contact {
	
	@Id
	@GeneratedValue
	private long contactId;
	
	private String name;
	private String imageUrl;
	private String status;
	
	public Contact() {
	}
	public Contact(String name, String imageUrl, String status) {
		this.name = name;
		this.imageUrl = imageUrl;
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public String getStatus() {
		return status;
	}
	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", name=" + name + ", imageUrl=" + imageUrl + ", status=" + status + "]";
	}
}
