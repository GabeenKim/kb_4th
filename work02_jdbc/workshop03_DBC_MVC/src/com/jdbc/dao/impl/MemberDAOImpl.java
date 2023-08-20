package com.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.MemberDAO;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;
import com.jdbc.vo.Member;

import config.ServerInfo;

public class MemberDAOImpl implements MemberDAO {
	
	//싱글톤 
	private static MemberDAOImpl dao = new MemberDAOImpl();
	private MemberDAOImpl() {
		System.out.println("MemberDAOImpl Creating...Using Singletone");
	}
	public static MemberDAOImpl getInstance() {
		return dao;
	}

	
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
	public void insertMember(Member member)throws DuplicateIDException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = getConnect();
			if(!idExists(member.getId(), conn)) {
				String query = "INSERT INTO member(id,name,email,phone) VALUES(seq_member.nextVal,?,?,?)";
				ps = conn.prepareStatement(query);
				
				ps.setString(1, member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				
				ps.executeUpdate();
				
				System.out.println(member.getName()+"님이 회원으로 등록되었습니다. ");
				
			}else {
				throw new DuplicateIDException(member.getName()+"님은 이미 존재하는 회원입니다.");
			}
			
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void deleteMember(int id) throws RecordNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = getConnect();
			if(idExists(id, conn)) {
				String query = "DELETE FROM member WHERE id =?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				
				ps.executeUpdate();
				System.out.println("회원이 삭제되었습니다.");
				
			}else {
				throw new RecordNotFoundException("존재하지 않는 회원입니다.");
			}
			
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public void updateMember(Member member)throws RecordNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try{
			conn = getConnect();
			if(idExists(member.getId(), conn)) {
				String query = "UPDATE member SET name = ?, email = ?, phone =? WHERE id = ?";
				ps = conn.prepareStatement(query);
				
				ps.setInt(4, member.getId());
				
				ps.setString(1,member.getName());
				ps.setString(2, member.getEmail());
				ps.setString(3, member.getPhone());
				
				ps.executeUpdate();
				System.out.println(member.getName()+"님의 회원 정보가 수정되었습니다. ");
				
			}else {
				throw new RecordNotFoundException(member.getName()+"님은 존재하지 않는 회원입니다.");
			}
			
		}finally {
			closeAll(conn, ps);
		}
		
	}

	@Override
	public Member getMember(int id) throws RecordNotFoundException, SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Member member = new Member();
		try{
			conn = getConnect();
			if(idExists(id, conn)) {
				String query = "SELECT id, name, email, phone FROM member WHERE id=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, id);
				
				rs=ps.executeQuery();
				
				while(rs.next()) {
					member.setId(rs.getInt("id"));
					member.setName(rs.getString("name"));
					member.setEmail(rs.getString("email"));
					member.setPhone(rs.getString("phone"));
				}
				
			}else {
				throw new RecordNotFoundException(member.getName()+"님은 존재하지 않는 회원입니다.");
			}
			
		}finally {
			closeAll(conn, ps,rs);
		}
		return member;
	}

	@Override
	public ArrayList<Member> getMember() throws RecordNotFoundException, SQLException {
		ArrayList<Member> temp = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
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

		}finally {
			closeAll(conn, ps,rs);
		}
		return temp;
	}

	@Override
	public ArrayList<Member> getMember(String name)throws RecordNotFoundException, SQLException{
		ArrayList<Member> temp = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
	
			String query = "SELECT id, name, email, phone FROM member WHERE name =?";
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
			
		}finally {
			closeAll(conn, ps,rs);
		}
		return temp;
	}
	
}
