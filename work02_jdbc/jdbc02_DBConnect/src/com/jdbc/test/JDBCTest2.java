package com.jdbc.test;

import com.jdbc.dao.CustomDAO;
import config.ServerInfo;

public class JDBCTest2 {
	
	public static void main(String[] args) throws Exception {
		CustomDAO dao = new CustomDAO();
		//dao.addCustom(1, "이정재", "삼성동");
		//dao.deleteCustom(1);
		
		//dao.addCustom(40, "이정재", "삼성동");
		//dao.deleteCustom(40);
		//dao.printACustom(10);
		
		//dao.printAllCustom();
		//dao.updateCustom(30, "Tomas", "Texas");
		//dao.printAllCustom();
		
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
