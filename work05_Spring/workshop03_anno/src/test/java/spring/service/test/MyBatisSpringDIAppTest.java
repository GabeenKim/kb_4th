package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.service.test.TestUtil;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;
import spring.service.domain.MemberVO;

public class MyBatisSpringDIAppTest {

	public static void main(String[] args) throws Exception {
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
								new String[] {	"/beans/userservice13.xml"	 }
									                                                    );
		//==> IoC Container 로 부터 획득한 UserDAO 인스턴스 획득
		MemberService memberService = (MemberService)context.getBean("memberDAOServiceImpl");
		
		MemberVO member = new MemberVO("hahaha", "1234", "이국민", "역삼");
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//1.UserService.addUser(user) Test
		System.out.println(":: 1. add(INSERT)  ? ");
		memberService.registerMember(member);
		
		System.out.println("============ 로그인  ============ ");
		member.setId("hahaha");
		member.setPassword("1234");
		if(memberService.login(member)) System.out.println("로그인되었습니다.");
		else System.out.println("아이디와 비밀번호가 일치하지 않습니다.");;

		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//2.UserService.getUser(userId) Test
		member = memberService.getMember("hahaha");
		System.out.println(":: 2. get(SELECT)  ? "+member);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//3.UserService.uadateUser(user) Test
		member.setName("장보고");
		System.out.println(":: 3. update(UPDATE)  ? ");
		memberService.updateMember(member);
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//4.UserService.getUser(userId) Test
		member = memberService.getMember("hahaha");
		System.out.println(":: 4. get(SELECT)  ? "+member);

		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
		//5.UserDAO.removeUser(userId) Test
		//==> UserService 에는 removeUser가 없으므로, DAO에서 직접 호출 Test
		MemberDAO memberDAO = (MemberDAO)context.getBean("memberDAOImpl");
		System.out.println(":: 5. remove(DELETE)  ? "+memberDAO.deleteMember("hahaha"));
		
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		//6.UserService.getUserList() Test
		System.out.println(":: 6. all User(SELECT)  ? ");
		List<MemberVO> list = memberService.showAllMember(new MemberVO());
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.print( "<"+ ( i +1 )+"> 번째 회원 정보... ");
			System.out.println( list.get(i).toString() );
		}
		System.out.println("///////////////////////////////////////////////////////////////////////////////////////");
		
	}

}
