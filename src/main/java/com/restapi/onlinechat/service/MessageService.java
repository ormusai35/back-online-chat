package com.restapi.onlinechat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.model.Message;
import com.restapi.onlinechat.repository.ContactRepository;
import com.restapi.onlinechat.repository.MessageRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ContactRepository contactRepository;

	public List<Message> getMessagesOfContact(Long contactId) {
		return messageRepository.findByContactId(contactId);
	}

	public Message addMessage(long contactId, Message message) {
		Contact contact = contactRepository.findById(contactId).get();
		message.setContact(contact);
		return messageRepository.save(message);
	}
}
