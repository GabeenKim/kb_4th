package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/*
  	디비 연결 과정 
  	1. 서버의 정보를 가지고 있는 Driver를 메모리에 로딩
  	
 */
public class DBConnectionTest1 {
	
	public DBConnectionTest1() {
		//JDBC 4단계....
		
		try {
			//1.Driver loading 과정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("Driver loading....Success");
	
			//2.DB Connection
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE"; //localhost
			String user = "mykb";
			String password = "1234";
			
			//연결 성공 시 Connection객체가 반환 됨. 
			Connection conn=DriverManager.getConnection(url, user, password);
			System.out.println("DB Connection....Success");
			
			//3.PreparedStatement 객체 생성//INSERT문을 사용할 때 정확하게 하기 위해 컬럼명도 적어주는게 좋다! 
			String query = "INSERT INTO custom(id,name,address) VALUES(?,?,?)"; //입력할 값의 개수에 따라 ?
			PreparedStatement ps =conn.prepareStatement(query);
			System.out.println("Creating PreparedStatement....");
			
			//바인딩: ?에 값을 넣는다. 데이터 타입에 따라 set~으로 삽입
 			ps.setInt(1,30); //1:?의 순서 ,2:바인딩 값
			ps.setString(2, "Gabeen");
			ps.setString(3, "LA");
			
			/*
			 * 채워지지 않은 값이 있는 경우 컬럼명의 개수와 ?의 개수 set의 개수를 없는 값을 빼고 작성한다. 
			 String query = "INSERT INTO custom(id, name) VALUES(?,?)"; //입력할 값의 개수에 따라 ?
			...
			
			//바인딩: ?에 값을 넣는다. 데이터 타입에 따라 set~으로 삽입
 			ps.setInt(1,30); //1:?의 순서 ,2:바인딩 값
			ps.setString(2, "Gabeen");
			 */
			
			//4.쿼리문 실행 
			int result = ps.executeUpdate();
			System.out.println(result);

		}catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Driver loading fail....");
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("DB Connection....Fail");
		}
		
	}
	public static void main(String[] args) {
		new DBConnectionTest1();

	}

}
