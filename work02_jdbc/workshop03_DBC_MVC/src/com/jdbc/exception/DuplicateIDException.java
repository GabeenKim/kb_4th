package com.jdbc.exception;

public class DuplicateIDException extends Exception{
	public DuplicateIDException() {
		this("This is DuplicationSSNException...");
	}
	public DuplicateIDException(String message) {
		super(message);
	}
}
