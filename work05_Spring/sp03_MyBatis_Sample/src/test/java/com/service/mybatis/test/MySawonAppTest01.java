package com.service.mybatis.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest01 {

	public static void main(String[] args) throws IOException {
		//1. 폼으로부터 가입하려는 사원의 정보를 받는다. -> 지금은 객체 생성해서 
		MySawon pvo = new MySawon();
//		pvo.setId("kblife");
//		pvo.setPwd("1234");
//		pvo.setName("김국민");
//		pvo.setAge(34);
		
//		pvo.setId("hahash");
//		pvo.setPwd("1111");
//		pvo.setName("김연아");
//		pvo.setAge(33);
		
		pvo.setId("abcd");
		pvo.setPwd("2222");
		pvo.setName("공유");
		pvo.setAge(42);
		
		//2. SqlMapConfig.xml 파일을 읽어 들인다. 
		Reader r =Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//3.SqlSessionfactory 생성
		SqlSessionFactory factory= new SqlSessionFactoryBuilder().build(r);
		
		//4.SqlSession 생성
		SqlSession session = factory.openSession();
		System.out.println("SqlSession이 만들어졌습니다.");
		
		/*
		 * SqlSession이 쿼리문을 수행하는 모든 기능을 다 가지고 있다. 
		 * int insert()
		 * int delete()
		 * int update()
		 
		 * List selectList() => return type : List
		 * Object selectOwn() => return type : Object
		 */
		//sawonAdd 쿼리문을 단위 테스트 ... insert()
		session.insert("SawonMapper.sawonAdd",pvo);//디비입력
		System.out.println(pvo.getName()+"님이 회원등록 성공~");
		
		session.commit();
		session.close();
	}

}
