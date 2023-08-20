package com.edu.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.edu.dto.Lecture;
import com.edu.dto.Teacher;
import com.edu.dto.User;

public interface EduDAO{
	Connection getConnect() throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn)throws SQLException;
	void closeAll(PreparedStatement ps, Connection conn,ResultSet rs)throws SQLException;
	
	
	//공통 기능
	public ArrayList<User> FindAllTeacher(); 
	public ArrayList<User> FindTeacherBySubject(String subject);
	public ArrayList<Lecture> FindLectureByTeacher(int teacherId);
	public Lecture FindLectureById(int lectureId);
	public ArrayList<Lecture> FindBestLectures();
	
	//관리자
	public void addTeacher(Teacher teacher);
	public void updateTeacher(Teacher teacher);
	public void deleteTeacher(int teacherId);
	
	//강의자
	public void addLecture(Lecture lecture);
	public void updateLecture(Lecture lecture);
	
	//수강자
	public ArrayList<Lecture> getAllMyLecture(int studentId);
	public void applyLecture(int studentId, Lecture lecture);
	public void cancleLecture(int studentId, Lecture lecture);
	public boolean likePossible(int studentId, int lectureId);
	public void likeLecture(int lectureId);
	public boolean discountPossible(int studentId, int teacherId);
	
}