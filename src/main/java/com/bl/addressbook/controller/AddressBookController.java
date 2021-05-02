package com.bl.addressbook.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.dto.ResponseDTO;
import com.bl.addressbook.dto.UpdatedContactDTO;
import com.bl.addressbook.service.IAddressBookService;

/**
 * connection to server
 * @author Tejas Dev
 *
 */
@RestController
@RequestMapping("/addressbook")
public class AddressBookController{

	@Autowired
	private IAddressBookService addressBookService;
	
	/**
	 * API to create new contact
	 * @param contact
	 * @return new contact
	 */
	@PostMapping
	public ResponseEntity<ResponseDTO> addContact(@Valid @RequestBody ContactDTO contact){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.addContact(contact), "Contact created"), HttpStatus.CREATED);
	}
	
	/**
	 * API to get all contact from DB
	 * @return all contacts from DB
	 */
	@GetMapping("/all")
	public ResponseEntity<ResponseDTO> getContact() {
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.getContacts(), "Contact fetched"), HttpStatus.OK);
	}
	
	/**
	 * API to get contact by id
	 * @param id
	 * @return Contact
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ResponseDTO> getContactById(@PathVariable("id") int id){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.getcontactById(id), "contact Fetched"), HttpStatus.OK);
	}
	
	/**
	 * API to update contact
	 * @param id
	 * @param contact
	 * @return updated contact
	 */
	@PutMapping("/update/{id}")
	public ResponseEntity<ResponseDTO> updateContact(@PathVariable("id") int id, @Valid @RequestBody UpdatedContactDTO contact){
		return new ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.updateContact(id, contact), "contact Updated"),HttpStatus.OK);
	}
	
	/**
	 * API to delete contact
	 * @param id
	 * @return deleted contact
	 */
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseDTO> deleteContact(@PathVariable("id") int id){
		return new  ResponseEntity<ResponseDTO>(new ResponseDTO(addressBookService.deleteContact(id), "contact deleted "), HttpStatus.OK);
	}
}