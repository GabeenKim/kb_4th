package com.edu.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.dto.Lecture;
import com.edu.service.EduDAO;

import config.ServerInfo;

import com.edu.dto.Teacher;
import com.edu.dto.User;

public class EduDAOImpl implements EduDAO {
	
	private static EduDAOImpl dao = new EduDAOImpl();
	private EduDAOImpl() {
		System.out.println("EduDAOImpl Creating...Using Singletone");
	}
	public static EduDAOImpl getInstance() {
		return dao;
	}
	
	////////////////////공통적인 로직      //////////////////////////////////
	@Override
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");		
		return conn;
	}
	
	@Override
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();		
	}
	
	@Override
	public void closeAll(PreparedStatement ps, Connection conn,ResultSet rs ) throws SQLException {
		if(rs!=null) rs.close();
		closeAll(ps,conn);		
	}
	
	//학생 테이블과 선생 테이블의 아이디를 각각 찾아와야 하는데 메소드를 두 개를 생성해야 하나...? 여쭤보기! 
	public boolean studentIdExists(int id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
			
		String query = "SELECT student_id FROM student WHERE student_id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		return rs.next();
	}
	public boolean teacherIdExists(int id, Connection conn) throws SQLException {
		PreparedStatement ps = null;
		ResultSet rs = null;
			
		String query = "SELECT teacher_id FROM teacher WHERE teacher_id=?";
		ps = conn.prepareStatement(query);
		ps.setInt(1, id);
		rs = ps.executeQuery();
		return rs.next();
	}
	
	@Override
	public ArrayList<User> FindAllTeacher() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<User> list = new ArrayList<User>();
		try {
			conn = getConnect();
			
		}finally {
			
		}
		return null;
	}

	@Override
	public ArrayList<User> FindTeacherBySubject(String subject) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lecture> FindLectureByTeacher(int teacherId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lecture FindLectureById(int lectureId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Lecture> FindBestLectures() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//////////////////////////////////////////
	@Override
	public void addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTeacher(int teacherId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateLecture(Lecture lecture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Lecture> getAllMyLecture(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyLecture(int studentId, Lecture lecture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancleLecture(int studentId, Lecture lecture) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean likePossible(int studentId, int lectureId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void likeLecture(int lectureId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean discountPossible(int studentId, int teacherId) {
		// TODO Auto-generated method stub
		return false;
	}

}
