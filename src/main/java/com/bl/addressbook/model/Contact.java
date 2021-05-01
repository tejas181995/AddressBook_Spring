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
	private String city;
	private String state;
	private String phone;
	private String email;
	
	public Contact(ContactDTO contact) {
		
		this.firstName = contact.getFirstName();
		this.lastName = contact.getLastName();
		this.address = contact.getAddress();
		this.city = contact.getCity();
		this.state = contact.getState();
		this.phone = contact.getPhone();
		this.email = contact.getEmail();
	}
	
	public Contact() {
		super();
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
				+ address + ", city=" + city + ", state=" + state + ", phone=" + phone + ", email=" + email + "]";
	}

	
}
