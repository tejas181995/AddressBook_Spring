package com.bl.addressbook.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;

@Data
public class UpdatedContactDTO {
	
	@Nullable
	@Size(min = 3, max = 15)
	private String firstName;
	
	@Nullable
	@Size(min = 3, max = 15)
	private String lastName;
	
	@Nullable
	@Size(min = 3, max = 15)
	private String address;
	
	@Nullable
	@Size(min = 3, max = 15)
	private String city;
	
	@Nullable
	@Size(min = 3, max = 15)
	private String state;
	
	@Nullable
	@Pattern(regexp = "[0-9]{10}", message = "please enter valid phone")
	private String phone;
	
	@Nullable
	@Email(message = "please enter valid email")
	private String email;
	
}
