package com.springbootjdbc.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class StudentExceptionHandler {

	@ExceptionHandler(StudentNotFoundException.class)
	public @ResponseBody ExceptionResponse handleResourceNotFound(final StudentNotFoundException exception) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMsg());
		error.setStatusCode(exception.getCode());
		return error;
	}
	@ExceptionHandler(NoContentFoundException.class)
	public @ResponseBody ExceptionResponse handleNoContentFoundException(final NoContentFoundException exception) {
		ExceptionResponse error = new ExceptionResponse();
		error.setErrorMessage(exception.getMsg());
		error.setStatusCode(exception.getCode());
		return error;
	}
}