package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class JDBCTest1 {

	public JDBCTest1() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
		//Connection 객체 생성
		conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DataBase Connection...");
		
		
		//DELETE | 40번 삭제 - > 추후 이 부분을 delete 함수로
		/*
		String query ="DELETE custom WHERE ID = ?"; //프로그램에서는 값을 넣으면 안
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement  Creation...");
		//바인딩
		ps.setInt(1, 40);
		//쿼리문 실행 
		int row = ps.executeUpdate();
		System.out.println(row+"ROW DELETE OK");
	 	*/
		
		//UPDATE ㅣ 10번 고객의 이름을 James1으로 주소는 NY으로 변경
		/*
		String query = "UPDATE custom SET name=?, address =? WHERE ID =?";
		PreparedStatement ps = conn.prepareStatement(query);
		System.out.println("PreparedStatement  Creation...");
		
		ps.setString(1, "James1");
		ps.setString(2, "NY");
		ps.setInt(3, 10);
		
		int row = ps.executeUpdate();
		System.out.println(row+" ROW UPDATE OK");
		*/
		
		//SELECT | custom 테이블의 모든 정보 출력 
		String query = "SELECT ID, NAME, ADDRESS FROM custom";
		ps = conn.prepareStatement(query);
		
		rs = ps.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getInt("ID")+"\t"
			+rs.getString("NAME")+"\t"
			+rs.getString("ADDRESS"));
		}
	}
	finally {
		
		
		//close는 연 순서와 반대로 작성해줘야함. 
		rs.close();
		ps.close();
		//connection은 필수로 닫아줘야함!!!!!!
		conn.close();    
	}
		
	}
	
	public static void main(String[] args) throws SQLException {
		new JDBCTest1();
	}
	//드라이버 로딩은 제일 먼저 이뤄져야 하므로  statin 초기화
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success...");
		}catch(ClassNotFoundException e){
			System.out.println("Driver Loading Fail...");
		}
	}
}
