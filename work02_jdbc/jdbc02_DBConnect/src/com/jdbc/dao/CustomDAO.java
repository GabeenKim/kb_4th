package com.jdbc.dao;
/*
 	 Business 로직을 가지고 있는 DAO 클래스 
 	 하나의 기능이 완벽한 서비스 단위. 
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class CustomDAO {
	public CustomDAO() {
		System.out.println("CustomDAO...Creating...");
		
	}
	
	/////////////////// 공통적으로 반복되는 로직 //////////////////////
	private Connection getConnect() throws SQLException{ 
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("");
		return conn;
	}
	
	private void closeAll(Connection conn,PreparedStatement ps) throws SQLException{
		if (ps!=null) ps.close();
		if (conn!=null) conn.close();
	}
	//오버로딩
	private void closeAll(Connection conn,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(conn, ps);
		
	}
	
	
	////////////////////business logic//////////////////////
	public void addCustom(int id, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			//고정적 -> 공통적인 기능을 재정의하여 사용해야 함.
			conn = getConnect();
			
			//가변적
			String query = "INSERT INTO custom(id,name,address) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, addr);
					
			System.out.println(ps.executeUpdate()+"명 등록 성공");
		
		
		}finally {
			//고정적
			closeAll(conn, ps);
		}
	}

	public void deleteCustom(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "DELETE custom WHERE id =?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			System.out.println(ps.executeUpdate()+"명 삭제 성공");
			
		}finally {
			closeAll(conn, ps);
		}
		
	}
	
	public void updateCustom(int id, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			String query ="UPDATE custom SET address = ?, name = ? WHERE id = ?";
			
			ps =  conn.prepareStatement(query);
			ps.setInt(3, id);
			ps.setString(1, addr);
			ps.setString(2, name);
			
			System.out.println(ps.executeUpdate()+"명 수정 성공");
		}finally {
			closeAll(conn, ps);
		}
	}
	
	public void printAllCustom() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query ="SELECT id, name, address FROM custom";
			
			ps =  conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("id")+"\t"
								+rs.getString("name")+"\t"
								+rs.getString("address"));
			}
		}finally {
			closeAll(conn, ps,rs);
			
		}
	}
	
	public void printACustom(int id) throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			String query ="SELECT id, name, address FROM custom WHERE id=?";
			
			ps =  conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			//행이 한 개거나 없는 것이니까 if 사용
			if (rs.next()) System.out.println(rs.getString("name")+"\t"
												+rs.getString("address"));
			else System.out.println("없음");
		}finally {
			closeAll(conn, ps,rs);
			
		}
		
	}
}
