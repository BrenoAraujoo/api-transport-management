package com.shipping.exceptions.handler;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ValidationExceptionsHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandardError> validationError(MethodArgumentNotValidException e, HttpServletRequest request) {
		BindingResult br = e.getBindingResult();

		StandardError err = new StandardError();

		br.getFieldErrors().forEach(errors -> {
			err.getFieldError().add(errors.getDefaultMessage());
		});
		err.setTimestamp(Instant.now());
		err.setStatus(HttpStatus.BAD_REQUEST.value());
		err.setPath(request.getRequestURI());
		err.setError("Validation error");
		err.setMessage("One or more fields have a validation error");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
	}

}
