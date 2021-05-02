package com.bl.addressbook.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bl.addressbook.dto.ContactDTO;
import com.bl.addressbook.dto.UpdatedContactDTO;

import lombok.Data;

@Entity
@Data
public class Contact {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	
	
	public Contact() {
		super();
	}
		
	
	public Contact(ContactDTO contact) {
		
		this.firstName = contact.getFirstName();
		this.lastName = contact.getLastName();
		this.address = contact.getAddress();
		this.city = contact.getCity();
		this.state = contact.getState();
		this.phone = contact.getPhone();
		this.email = contact.getEmail();
	}

	public void updateContact(UpdatedContactDTO contact) {
	
		this.firstName = contact.getFirstName() == null ? this.firstName : contact.getFirstName();
		this.lastName = contact.getLastName() == null ? this.lastName : contact.getLastName();
		this.address = contact.getAddress() == null ? this.address : contact.getAddress();
		this.city = contact.getCity() == null ? this.city : contact.getCity();
		this.state = contact.getState() == null ? this.state :  contact.getState();
		this.phone = contact.getPhone() == null ? this.phone : contact.getPhone();
		this.email = contact.getEmail() == null ? this.email : contact.getEmail();
	}

}
