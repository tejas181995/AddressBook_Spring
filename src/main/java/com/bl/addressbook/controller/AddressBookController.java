package com.bl.addressbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.dto.ResponseDTO;
import com.bl.addressbook.service.IAddressBookService;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController{

	@Autowired
	private IAddressBookService addressBookService;
	
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contact){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.addContact(contact), "Contact created"), HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getContact() {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.getContacts(), "Contact fetched"), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.getcontactById(id), "contact Fetched"), HttpStatus.OK);
	}
}