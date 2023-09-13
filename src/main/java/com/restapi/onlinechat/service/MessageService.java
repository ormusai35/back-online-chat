package com.restapi.onlinechat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.model.Message;
import com.restapi.onlinechat.model.Msg;
import com.restapi.onlinechat.model.User;
import com.restapi.onlinechat.repository.ContactRepository;
import com.restapi.onlinechat.repository.MessageRepository;
import com.restapi.onlinechat.repository.UserRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessageRepository messageRepository;
	
	@Autowired
	private ContactRepository contactRepository;
	
	@Autowired
	private UserRepository userRepository;

//	public List<Message> getMessagesOfContact(Long contactId) {
//		return messageRepository.findByContactId(contactId);
//	}

//	public Message addMessage(long contactId, Message message) {
//		Optional<Contact> opContact = contactRepository.findById(contactId);
//		if(opContact.isPresent()) {
//			Contact contact = opContact.get();
//			message.setContact(contact);
//			message.setContact(contact);
//			return messageRepository.save(message);
//		}
//		return null;
//	}

	public List<Msg> getMessagesSenderReceiver(Long senderId, Long receiverId) {
		return this.messageRepository.findBySenderReceiver(senderId, receiverId);
	}
	
	public Msg addMsg(long senderId,long recieverId, Msg message) {
		Optional<User> opSender = userRepository.findById(senderId);
		Optional<User> opReciever = userRepository.findById(recieverId);
		if(opSender.isPresent() && opReciever.isPresent()) {
			User sender = opSender.get();
			User reciever = opReciever.get();
			message.setSender(sender);
			message.setReciever(reciever);
			return messageRepository.save(message);
		}
		return null;
	}
}
