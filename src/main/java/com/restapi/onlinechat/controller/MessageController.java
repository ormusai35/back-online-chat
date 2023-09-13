package com.restapi.onlinechat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.onlinechat.model.Contact;
import com.restapi.onlinechat.model.Message;
import com.restapi.onlinechat.model.Msg;
import com.restapi.onlinechat.service.ContactService;
import com.restapi.onlinechat.service.MessageService;
import com.sun.xml.bind.v2.runtime.unmarshaller.Receiver;

@CrossOrigin(origins="http://localhost:4200/")
@RestController
public class MessageController {

	@Autowired
	private MessageService messageService;

//	@GetMapping(path="get-messages-user-contact")
//	public ResponseEntity<List<Message>> getMessagesUserContact(@RequestParam Long contactId) {
//		return ResponseEntity.ok(messageService.getMessagesOfContact(contactId));
//	}

//	@PostMapping(path="send-message")
//	public ResponseEntity<Message> sendMessage(@RequestParam Long contactId, @RequestBody Message newMessage){
//		Message message = messageService.addMessage(contactId, newMessage);
//		System.out.println(message);
//		return message == null ? 
//				ResponseEntity.status(HttpStatus.NOT_MODIFIED).build()
//				: ResponseEntity.ok(message);
//	}
	
	@GetMapping(path="get-messages-sender-receiver")
	public ResponseEntity<List<Msg>> getMessagesUserContact(@RequestParam Long senderId, @RequestParam Long receiverId) {
		return ResponseEntity.ok(messageService.getMessagesSenderReceiver(senderId, receiverId));
	}
	
	@PostMapping(path="send-msg")
	public ResponseEntity<Msg> sendMsg(@RequestParam Long senderId, @RequestParam Long receiverId, @RequestBody Msg newMessage){
		Msg message = messageService.addMsg(senderId, receiverId, newMessage);
		System.out.println(message);
		return message == null ? 
				ResponseEntity.status(HttpStatus.NOT_MODIFIED).build()
				: ResponseEntity.ok(message);
	}
}
