package com.bl.addressbook.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactDTO {
	
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String phone;
	private String email;
	
}
