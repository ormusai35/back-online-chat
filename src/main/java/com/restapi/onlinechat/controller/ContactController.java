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
import com.restapi.onlinechat.service.ContactService;

@CrossOrigin(origins="*")
@RestController
public class ContactController {
	
	@Autowired
	private ContactService contactService; 
	
	@GetMapping(path="get-all-contacts")
	public ResponseEntity<List<Contact>> getAll(){
		return ResponseEntity.ok(this.contactService.getAllContacts());
	}
	
	@GetMapping(path="get-contacts/{userId}")
	public ResponseEntity<List<Contact>> getContactsByUserId(@PathVariable Long userId){
		return ResponseEntity.ok(this.contactService.getContactsByUserId(userId));
	}
	
	@PostMapping(path="add-contact")
	public ResponseEntity<Contact> addContact(@RequestBody Contact newContact, @RequestParam Long userId){
		Contact contact = this.contactService.addContact(newContact, userId);
		System.out.println(contact);
		if(contact != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(contact);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body(contact);
		}
		
	}
	
}
