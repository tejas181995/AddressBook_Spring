package com.bl.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ContactDTO {
	
	@NotEmpty(message = "please enter first name")
	@Size(min = 3, max = 15)
	private String firstName;
	
	@NotEmpty(message = "please enter last name")
	@Size(min = 3, max = 15)
	private String lastName;
	
	@NotEmpty(message = "please enter address")
	@Size(min = 3, max = 15)
	private String address;
	
	@NotEmpty(message = "please enter city ")
	@Size(min = 3, max = 15)
	private String city;
	
	@NotEmpty(message = "please enter state ")
	@Size(min = 3, max = 15)
	private String state;
	
	@Pattern(regexp = "[0-9]{10}", message = "please enter valid phone")
	private String phone;
	
	@Email(message = "please enter valid email")
	private String email;
	
}
