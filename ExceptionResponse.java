package com.springbootjdbc.exceptions;

public class ExceptionResponse {

	private String errorMessage;
	private int statusCode;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(final String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(final int statusCode) {
		this.statusCode = statusCode;
	}
	
	public ExceptionResponse(String errorMessage, int statusCode) {
		super();
		this.errorMessage = errorMessage;
		this.statusCode = statusCode;
	}

	public ExceptionResponse(String string) {
		super();
		this.errorMessage = errorMessage;
	}

	public ExceptionResponse() {
		super();
	}

	@Override
	public String toString() {
		return "ExceptionResponse [errorMessage=" + errorMessage + ", code=" + statusCode + "]";
	}
	
}
