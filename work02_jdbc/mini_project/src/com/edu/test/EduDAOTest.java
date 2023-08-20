package com.edu.test;

import java.util.ArrayList;

import config.ServerInfo;

public class EduDAOTest {
	public static void main(String[] args) throws Exception {
		EduDAO service = EduDAOImpl.getInstance();
		
		System.out.println("==============선생님 전체 조회==============");
		ArrayList<User> teachers = service.findAllTeacher();
		for(User t : teachers) {
			System.out.println(t);
		}
	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e){
			System.out.println("Driver Loading Fail...");
		}
	}
}
