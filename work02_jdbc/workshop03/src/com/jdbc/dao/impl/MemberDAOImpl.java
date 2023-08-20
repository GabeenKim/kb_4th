package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;

import com.jdbc.dao.MemberDAO;
import com.jdbc.dto.Member;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {

	private static MemberDAOImpl dao = new MemberDAOImpl();
	
	private MemberDAOImpl() {
		System.out.println("MemberDAOImpl Creating...Using Singletone");
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}
	
	////////////////////// 공통적인 로직 //////////////////////
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect...");
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(conn, ps);
	}
	
	///////////////////////// 비즈니스 로직 /////////////////////////
	public boolean idExists(int id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
			
		String query = "SELECT id FROM member WHERE id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public void insertMember(Member member) throws Exception {
		Connection conn = getConnect();
		PreparedStatement ps = null;
		
		try {
			 if(!idExists(member.getId(), conn)) { //해당하는 id가 없다면 추가 진행
				
				 String query = "INSERT INTO member (id, name, email, phone) VALUES(seq_member.nextVal, ? ,?, ?)";
				 ps = conn.prepareStatement(query);
				 
				 ps.setString(1, member.getName());
				 ps.setString(2, member.getEmail());
				 ps.setString(3, member.getPhone());
				 
				 ps.executeUpdate();
				 
			 }else {
				 //예외 발생 throw new DuplicateIDException();
				 throw new DuplicateIDException();
			 }
			
		}finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public void deleteMember(int id) throws Exception {
		Connection conn = getConnect();
		PreparedStatement ps = null;
		
		try {
			 if(idExists(id, conn)) { //해당하는 id가 있다면 추가 진행
				
				 String query = "DELETE member WHERE id = ?";
				 ps = conn.prepareStatement(query);
				 ps.setInt(1, id);
				 
				 //쿼리문 실행
				 System.out.println(ps.executeUpdate()+"명 회원 삭제");
			 }else {
				 //예외 발생 throw new RecordNotFoundException();
				 throw new RecordNotFoundException();
			 }
			
		}finally {
			closeAll(conn, ps);
		}
		
	}
	
	@Override
	public void updateMember(Member member) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = getConnect();
			if(idExists(member.getId(), conn)) { //업데이트 대상 멤버가 있다면 -> 업데이트
				String query = "UPDATE member SET name=?, email=?, phone=? WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setString(1, member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				ps.setInt(4, member.getId());
				
				ps.executeUpdate();
			} else {
				//예외 발생..throw new RecordNotFoundException()
				throw new RecordNotFoundException();
			}
		} finally {
			closeAll(conn, ps);
		}
	}

	@Override
	public Member getMember(int id) throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = new Member();
		try {
			conn = getConnect();
			if(idExists(id, conn)) { //찾는 멤버가 있는 경우
				String query = "SELECT id, name, email, phone FROM member WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				rs = ps.executeQuery();
				while(rs.next()) {
					member.setId(rs.getInt("id"));
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					member.setPhone(rs.getString("phone"));
				}
			} else {
				//예외 발생..throw new RecordNotFoundException()
				throw new RecordNotFoundException();
			}
		} finally {
			closeAll(conn, ps, rs);
		}
		return member;
	}
	
	@Override
	public ArrayList<Member> getMember() throws Exception {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    ArrayList<Member> temp = new ArrayList<Member>();
	    
	    try {
	        conn = getConnect();
	            String query = "SELECT id, name, email, phone FROM member";
	            ps = conn.prepareStatement(query);
	            rs = ps.executeQuery();
	            
	            boolean find = rs.next();
				if(find) {
					while(rs.next()) {
						Member member = new Member();
						member.setId(rs.getInt("id"));
						member.setName(rs.getString("name"));
						member.setEmail(rs.getString("email"));
						member.setPhone(rs.getString("phone"));
						
						temp.add(member);
					}
				}else {
					throw new RecordNotFoundException("회원이 존재하지 않습니다.");
				}
	            
	    } finally {
	        closeAll(conn, ps, rs);
	    }
	    return temp;
	    
	}
	@Override
	public ArrayList<Member> getMember(String name) throws Exception {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;

	    ArrayList<Member> temp = new ArrayList<Member>();
	    
	    try {
	        conn = getConnect();
	            String query = "SELECT id, name, email, phone FROM member WHERE name = ?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, name);
	            
	            rs = ps.executeQuery();
	            
	            boolean find = rs.next();
				if(find) {
					while(rs.next()) {
						Member member = new Member();
						member.setId(rs.getInt("id"));
						member.setName(rs.getString("name"));
						member.setEmail(rs.getString("email"));
						member.setPhone(rs.getString("phone"));
						
						temp.add(member);
					}
				}else {
					throw new RecordNotFoundException(name+"님은 존재하지 않는 회원입니다.");
				}
	            
	    } finally {
	        closeAll(conn, ps, rs);
	    }
	    return temp;
	}
	
}
