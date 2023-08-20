package com.edu.test;

import java.util.ArrayList;

import com.edu.dao.EduDAO;
import com.edu.dao.impl.EduDAOImpl;
import com.edu.vo.Lecture;
import com.edu.vo.Teacher;
import com.edu.vo.User;

public class EduTest {

	public static void main(String[] args) throws Exception {
		EduDAO service = EduDAOImpl.getInstance();
		
		System.out.println("==============선생님 전체 조회==============");
		ArrayList<User> teachers = service.findAllTeacher();
		for(User t : teachers) {
			System.out.println(t);
		}
		
		System.out.println("==============과목별 선생님 조회==============");
		ArrayList<User> teachers1 = service.findTeacherBySubject("수학");
		for(User t : teachers1) {
			System.out.println(t);
		}
//		
//		System.out.println("==============선생님별 강의 조회==============");
//		ArrayList<Lecture> lectures = service.findLectureByTeacher(3);
//		for(Lecture l : lectures) {
//			System.out.println(l);
//		}
//		
//		System.out.println("==============강의 id로 강의 조회==============");
//		Lecture lecture = service.findLectureById(2);
//		System.out.println(lecture);
//		
//		System.out.println("==============인기 강의 목록 조회==============");
//		ArrayList<Lecture> lectures1 = service.findBestLectures();
//		for(Lecture l : lectures1) {
//			System.out.println(l);
//		}
		
		////////////////////////////////////////////////////////
		
//		System.out.println("================= addLecture 강의 추가 =================");
//		service.addLecture(new Lecture(0, "미분", "수학", 0, "1000000"));
//		service.addLecture(new Lecture(1, "확통", "수학", 0, "800000"));
//		service.addLecture(new Lecture(2, "기하와 벡터", "수학", 0, "53000"));
//		service.addLecture(new Lecture(0, "화법과 작문", "국어", 0, "124000"));
//		service.addLecture(new Lecture(1, "문법", "국어", 0, "90000"));
//		
//		System.out.println("================= updateLecture 강의 수정 =================");
//		service.updateLecture(new Lecture(1, "확통", "수학", 0, "1000000"));
//		
//		System.out.println("================= getAllLectures 강의 목록 조회 =================");
//		
//		ArrayList<Lecture> list = service.getAllMyLecture(1);
//		for(Lecture lec : list) {
//			System.out.println(lec);
//		}
//		

		/*
//		System.out.println("================= applyLecture 수강 신청 =================");
//		Lecture lec = new Lecture(2, "미분", "수학", 0, "1000000");
//		service.applyLecture(1, lec);
//		
//		System.out.println("================= calcelLecture 수강 철회 =================");
//		Lecture lec = new Lecture(1, "미분", "수학", 0, "1000000");
//		service.cancleLecture(1, lec);
		*/
		
		//////////////////////////////////////////////////////////////////
		
		
//		System.out.println("==============강의자 추가==============");
//		//service.addTeacher(new Teacher(0,"호선","octopus@naver.com","체육"));
//		
//		System.out.println("==============강의자 수정==============");
//		//service.updateTeacher(new Teacher(3,"문승현","kim@naver.com","수학"));
//		
//		//System.out.println("==============강의자 삭제==============");
//		//service.deleteTeacher(6);
//		
//		System.out.println("==============좋아요 누르기==============");
//		service.likeLecture(1,2);
//		
//		System.out.println("==============특정 과목 강의들 할인가==============");
//		System.out.println(service.discountLecture("수학", 10));
	}

}
