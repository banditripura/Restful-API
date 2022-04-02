package com.springbootjdbc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StudentNotFoundException extends RuntimeException {
	
	int code;
	String msg;
	private static final long serialVersionUID = 1L;
	
	public StudentNotFoundException() {
		super();
	}
	
	public StudentNotFoundException(final String message) {
		super(message);
	}
	public StudentNotFoundException(final String message,int code) {
		super();
		this.code = code;
		this.msg = message;
	}

	

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
