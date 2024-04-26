package com.govtech.demo.config;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

import com.govtech.demo.exception.NoDataException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class ControllerAdvice {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleAllException(Exception ex, ServletWebRequest request) {
		return handleException(ex, request, "Server side error occurred.",
				HttpStatus.INTERNAL_SERVER_ERROR, true);
	}

	@ExceptionHandler(NoDataException.class)
	public ResponseEntity<String> handleAuthorityException(Exception ex, ServletWebRequest request) {
		return handleException(ex, request, "No Data Available", HttpStatus.SERVICE_UNAVAILABLE);
	}

	@ExceptionHandler(HandlerMethodValidationException.class)
	public ResponseEntity<String> handleHandlerMethodValidationException(HandlerMethodValidationException ex,
			ServletWebRequest request) {
		return handleException(ex, request, "Validation error: " +
				ex.getAllErrors().stream().map(item -> item.getDefaultMessage())
						.collect(Collectors.joining(", ")),
				HttpStatus.BAD_REQUEST);
	}

	private ResponseEntity<String> handleException(Exception ex, ServletWebRequest request, String message,
			HttpStatus httpStatus) {
		return handleException(ex, request, message, httpStatus, false);
	}

	private ResponseEntity<String> handleException(Exception ex, ServletWebRequest request, String message,
			HttpStatus httpStatus, boolean printStackTrace) {
		if (printStackTrace) {
			log.error("Request path: {}", request.getRequest().getRequestURI());
			log.error("Exception occurred", ex);
		}
		return new ResponseEntity<>(message, httpStatus);
	}
}
