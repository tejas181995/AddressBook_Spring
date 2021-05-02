package com.bl.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.model.Contact;
import com.bl.addressbook.repository.IAddressBookRepo;

@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepo addressbookRepo;
	
	@Override
	public Contact addContact(ContactDTO contact) {
		Contact newContact = new Contact(contact);
		return this.addressbookRepo.save(newContact);
	}

	@Override
	public Optional<Contact> getcontactById(int contactId) {
		return addressbookRepo.findById(contactId);
	}

	@Override
	public List<Contact> getContacts() {
		return addressbookRepo.findAll();
	}

}
