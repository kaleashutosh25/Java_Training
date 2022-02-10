package com.hcl.petShop.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HadleAllExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = InvalidUserException.class)
	public ResponseEntity<Object> InvalidUserException(InvalidUserException exception) {
		Map<String, String> responseBody = new HashMap<>();
		responseBody.put("TimeStamp:", LocalDateTime.now().toString());
		responseBody.put("ErrorMessage", "Invlaid Username,Length should be bwetween 4 to 20 charatcters");
		return new ResponseEntity<>(responseBody, HttpStatus.LENGTH_REQUIRED);
	}

	@ExceptionHandler(value = PetNotAvailableException.class)
	public ResponseEntity<Object> PetNotAvailableException(PetNotAvailableException exception) {
		Map<String, String> responseBody = new HashMap<>();
		responseBody.put("TimeStamp:", LocalDateTime.now().toString());
		responseBody.put("ErrorMessage", "This Pet is not available for sale ");
		return new ResponseEntity<>(responseBody, HttpStatus.NOT_FOUND);
	}

}
