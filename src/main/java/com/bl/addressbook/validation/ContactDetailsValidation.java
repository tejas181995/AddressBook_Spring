package com.bl.addressbook.validation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.bl.addressbook.dto.ResponseDTO;


@ControllerAdvice
public class ContactDetailsValidation extends ResponseEntityExceptionHandler {

	 protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
														             HttpHeaders headers,
														             HttpStatus status,
														             WebRequest request) {
		List<String> errorMsg = ex.getBindingResult().getAllErrors().stream()
		.map(error -> error.getDefaultMessage()).collect(Collectors.toList());
		return new ResponseEntity<>(
		new ResponseDTO(errorMsg, "please validate fields"),
		HttpStatus.BAD_REQUEST);
}
}
