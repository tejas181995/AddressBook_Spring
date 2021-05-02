package com.bl.addressbook.service;

import java.util.List;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.dto.UpdatedContactDTO;
import com.bl.addressbook.model.Contact;

public interface IAddressBookService {
	
	public Contact addContact(ContactDTO contact);
	public  Contact getcontactById(int contactId);
	public List<Contact> getContacts();
	Contact updateContact(int id, UpdatedContactDTO contact);
	public Contact deleteContact(int id);
}
