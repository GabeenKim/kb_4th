package com.jdbc.exception;

public class RecordNotFoundException extends Exception{
	public RecordNotFoundException() {
		this("존재하지 않는 id값 입니다.");
	}
	
	public RecordNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}