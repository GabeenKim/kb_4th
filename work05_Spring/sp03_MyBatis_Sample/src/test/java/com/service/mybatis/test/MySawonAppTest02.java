package com.service.mybatis.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.service.mybatis.vo.MySawon;

public class MySawonAppTest02 {

	public static void main(String[] args) throws IOException {
		//1.SqlMapConfig.xml 문서 읽어 들인다
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		
		//2.SqlSessionFactory 리턴 받고
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		
		//3.SqlSession 리턴 받고
		SqlSession session = factory.openSession();
		
		//4. selectList() 호출해서 정보출력
		//namespace.id를 아규먼트로 넣어주기
		List<MySawon> list = session.selectList("SawonMapper.sawonList");
		for(MySawon ms : list) System.out.println(ms);
		session.close();

	}

}
