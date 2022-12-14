package com.ksalhab.caragency.layers.errorHandling;

import com.ksalhab.caragency.layers.exceptions.ApplicationException;
import com.ksalhab.caragency.layers.exceptions.DataNotFoundException;
import com.ksalhab.caragency.layers.exceptions.SemanticException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ExceptionHandler(DataNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public ErrorMessage handleDataNotFound(DataNotFoundException exception) {
		return new ErrorMessage(exception.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(SemanticException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleSemanticException(SemanticException exception) {
		return new ErrorMessage(exception.getMessage());
	}

	@ResponseBody
	@ExceptionHandler(ApplicationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ErrorMessage handleGenericException(ApplicationException exception) {
		return new ErrorMessage(exception.getMessage());
	}

}
