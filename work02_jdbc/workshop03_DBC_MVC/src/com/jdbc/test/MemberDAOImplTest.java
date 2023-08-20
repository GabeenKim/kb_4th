package com.jdbc.test;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.dao.MemberDAO;
import com.jdbc.dao.impl.MemberDAOImpl;
import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;
import com.jdbc.vo.Member;

import config.ServerInfo;

public class MemberDAOImplTest {

	public static void main(String[] args) {
		MemberDAO service = MemberDAOImpl.getInstance();
		
		try {
			//회원등록
//			service.insertMember(new Member(1,"Jane","rlarkqls1250@naver.com","010-3671-4401"));
//			service.insertMember(new Member(2,"Tomas","Tomas@naver.com","010-1234-1234"));
//			service.insertMember(new Member(3,"Bob","Bob@naver.com","010-1234-1234"));
			
			//회원 삭제
//			service.deleteMember(3);
			
			//회원 수정
			service.updateMember(new Member(5,"James","James@naver.com","010-1234-5678"));
			
			//아이디에 해당하는 회원 조회
//			System.out.println(service.getMember(1));
			
			//회원 전체 조회
//			ArrayList<Member> list = service.getMember();
//			for(Member m : list) System.out.println(m);
			
			//name에 해당하는 회원 조회
//			ArrayList<Member> list1 = service.getMember("James");
//			for(Member m : list1) System.out.println(m);
			
			
			
		}
//		catch (DuplicateIDException e) {
//			System.out.println(e.getMessage());
//		}
		catch (RecordNotFoundException e) {
			System.out.println(e.getMessage());
		}catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		

	}
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success");
		   }catch(ClassNotFoundException e){
		      System.out.println("Driver Loading Fail");
		   }
	}
}
