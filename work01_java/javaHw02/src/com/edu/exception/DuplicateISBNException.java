package com.edu.exception;

public class DuplicateISBNException extends Exception{

	public DuplicateISBNException(){
		this("This is DuplicationSSNException");
	}
	public DuplicateISBNException(String message) {
		super(message);
	}

}
