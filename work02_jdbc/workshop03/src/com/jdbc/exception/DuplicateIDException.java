package com.jdbc.exception;

public class DuplicateIDException extends Exception {
	public DuplicateIDException() {
		this("중복되는 id 값 입니다.");
	}
	
	public DuplicateIDException(String errorMsg) {
		super(errorMsg);
	}
}