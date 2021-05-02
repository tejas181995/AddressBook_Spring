package com.bl.addressbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.dto.UpdatedContactDTO;
import com.bl.addressbook.exception.AddressBookException;
import com.bl.addressbook.model.Contact;
import com.bl.addressbook.repository.IAddressBookRepo;

/**
 * 
 * @author Tejas Dev
 *
 */
@Service
public class AddressBookService implements IAddressBookService {

	@Autowired
	private IAddressBookRepo addressbookRepo;
	
	/**
	 * method to add contact in DB
	 */
	@Override
	public Contact addContact(ContactDTO contact) {
		Contact newContact = new Contact(contact);
		return this.addressbookRepo.save(newContact);
	}

	/**
	 * method to get contact by id
	 */
	@Override
	public Contact getcontactById(int contactId) {
		return addressbookRepo.findById(contactId).orElseThrow(() -> 
						new AddressBookException(AddressBookException.exceptionType.CONTACT_NOT_FOUND, "Contact does not exist"));
	}

	/**
	 * method to get all contact from DB
	 */
	@Override
	public List<Contact> getContacts() {
		return addressbookRepo.findAll();
	}

	/**
	 * method to update contact
	 */
	@Override
	public Contact updateContact(int id, UpdatedContactDTO contact) {
		Contact currContact = getcontactById(id);
		currContact.updateContact(contact);
		return this.addressbookRepo.save(currContact);
	}

	/**
	 * method to delete contact from DB
	 */
	@Override
	public Contact deleteContact(int id) {
		Contact deleteContact = getcontactById(id);
		addressbookRepo.deleteById(id);
		return deleteContact;
	}

	

}
