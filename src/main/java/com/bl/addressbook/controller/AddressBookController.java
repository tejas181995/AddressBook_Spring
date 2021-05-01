package com.bl.addressbook.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.bl.addressbook.service.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController{

	List<Contact> contacts = new ArrayList<>();
	
	@Autowired
	private IAddressBookService addressBookService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@RequestBody ContactDTO contact){
		Contact newContact = addressBookService.addContact(contact);
		contacts.add(newContact);
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(newContact, "Contact created"), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<ResponseDTO> getContact() {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(contacts, "Contact fetched"), HttpStatus.CREATED);
		}
}