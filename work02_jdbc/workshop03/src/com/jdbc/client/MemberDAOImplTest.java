package com.jdbc.client;

import java.util.ArrayList;

import com.jdbc.dao.MemberDAO;
import com.jdbc.dao.impl.MemberDAOImpl;
import com.jdbc.dto.Member;

import config.ServerInfo;

public class MemberDAOImplTest {

	public static void main(String[] args) throws Exception {
		MemberDAO service = MemberDAOImpl.getInstance();
		
		System.out.println("==============멤버 추가==============");
		service.insertMember(new Member(0, "Jane", "ghenrhk@naver.com", "010-1599-5456"));
		service.getMember();
		
		System.out.println("==============멤버 삭제==============");
		System.out.println("멤버를 삭제합니다.");
		service.deleteMember(1);
		//service.deleteMember(2);
		
		System.out.println("==============멤버 id로 확인==============");
		System.out.println("멤버를 확인합니다.");
		Member member1 = service.getMember(1);
		System.out.println(member1.getName()+"님이 확인되었습니다.");
		
		System.out.println("==============멤버 수정==============");
		System.out.println("멤버를 수정합니다.");
		service.updateMember(new Member(1, "woogie","goo@naver.com","010-222-2222"));
		service.getMember();
		
		System.out.println("==============멤버 전체 확인==============");
		ArrayList<Member> list = new ArrayList<>();
		System.out.println("멤버 전체를 확인합니다.");
		list = service.getMember();
		for(Member m : list) {
			System.out.println(m.getName()+"의 id : "+m.getId());
		}
		
		System.out.println("==============멤버 이름으로 확인==============");
		ArrayList<Member> list1 = new ArrayList<>();
		System.out.println("멤버 이름으로 확인합니다.");
		list1 = service.getMember("boogie");
		for(Member m : list1) {
			System.out.println(m.getName()+"의 id : "+m.getId());
		}
	}
	
	static{
		try{
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success");
	   }catch(ClassNotFoundException e){
	      System.out.println("Driver Loading Fail");
	   }
	}

}
