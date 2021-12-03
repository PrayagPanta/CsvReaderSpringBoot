package com.example.csvReader.exceptionHandlers;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class IOExceptionHandler {
	@ExceptionHandler(IOException.class)
	public ResponseEntity<?> handleIOException(IOException exception) {
		HashMap<String, String> message = new HashMap<String, String>();
		message.put("Http Status Code", "404");
		message.put("Error", exception.getLocalizedMessage());
		return new ResponseEntity<Object>(message, HttpStatus.NOT_FOUND);
	}
}
