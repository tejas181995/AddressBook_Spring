package com.bl.addressbook.service;

import java.util.List;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.model.Contact;

public interface IAddressBookService {
	
	public Contact addContact(ContactDTO contact);
	
}
