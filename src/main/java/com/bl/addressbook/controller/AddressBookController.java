package com.bl.addressbook.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.dto.ResponseDTO;
import com.bl.addressbook.model.Contact;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {

	Contact newContact;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contact){
		newContact = new Contact(contact);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(newContact, "Contact created"), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getContact() {
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(newContact, "Contact fetched"), HttpStatus.CREATED);
	}
}