package com.bl.addressbook.service;

import org.springframework.stereotype.Service;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.model.Contact;

@Service
public class AddressBookService implements IAddressBookService {

	@Override
	public Contact addContact(ContactDTO contact) {
		Contact newContact = new Contact(contact);
		return newContact;
	}
	
}
