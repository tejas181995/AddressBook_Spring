package com.bl.addressbook.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bl.addressbook.dto.ContactDTO;

@Entity
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int serialNo;
	
	private String firstName;
	private String lastName;
	private String address;
	
	
	public Contact() {
		super();
	}

	public Contact(ContactDTO contact) {

		this.firstName = contact.getFirstName();
		this.lastName = contact.getLastName();
		this.address = contact.getAddress();
	}

	
	public int getSerialNo() {
		return serialNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Contact [serialNo=" + serialNo + ", firstName=" + firstName + ", lastName=" + lastName + ", address="
				+ address + "]";
	}
	
}
