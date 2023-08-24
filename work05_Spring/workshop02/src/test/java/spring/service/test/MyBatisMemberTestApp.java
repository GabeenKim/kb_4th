package spring.service.test;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import spring.service.domain.MemberVO;

public class MyBatisMemberTestApp {

	public static void main(String[] args) throws IOException {
		
		Reader r = Resources.getResourceAsReader("config/SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(r);
		SqlSession session = factory.openSession();
		
		MemberVO pvo = new MemberVO("hahaha", "1234", "이국민", "역삼");
		
		
//		//0. 회원 가입하기 
//		System.out.println("============ 회원 가입 ============ ");
//		Object obj = session.insert("MemberMapper.registerMember", pvo);
//		session.commit(); 
//		
//		System.out.println(pvo.getName()+"님이 가입 되었습니다."); //1
//		System.out.println("\n");
		
//		//1. 로그인하기 - id와 pw가 같으면 해당 회원 정보 리턴
//		
//		System.out.println("============ 로그인  ============ ");
//		String mem1 = session.selectOne("MemberMapper.login", pvo);
//		if(mem1 !=null)	System.out.println(mem1+"님, 로그인 되었습니다.");
//		else System.out.println("아이디와 비밀번호가 올바르지 않습니다.");
//		
		
		//2. 회원 전체  보기 
		System.out.println("============ 전체 회원 목록 ============ ");
		List<MemberVO> list = session.selectList("MemberMapper.showAllMember");
		for (int i =0 ;  i < list.size() ; i++) {
			System.out.println( i+"번째 회원.."+ list.get(i).toString() );
		}
		
//		//3. 회원 정보 수정 하기
//		pvo.setName("이나라");
//		pvo.setPassword("121212");
//		pvo.setAddress("강남");
//		System.out.println("============ 회원 정보 수정 ============ ");
//		Object obj = session.insert("MemberMapper.updateMember", pvo);
//		session.commit(); 
//		
//		System.out.println(pvo.getName()+"님의 정보가 수정되었습니다."); //1
//		System.out.println("\n");
//		
//		System.out.println("============ 전체 회원 목록 ============ ");
//		list = session.selectList("MemberMapper.showAllMember");
//		for (int i =0 ;  i < list.size() ; i++) {
//			System.out.println( i+"번째 회원.."+ list.get(i).toString() );
//		}
		

//		//4. id가 hahaha인  회원 검색하기
//		String searchId = "hahaha";
//		System.out.println("============ 회원 검색 하기 ============ ");
//		MemberVO mem1 = session.selectOne("MemberMapper.getMember", searchId);
//		if(mem1 !=null)	System.out.println(mem1.toString());
//		else System.out.println("없는 회원입니다.");
//		
		
		
//		//5. 회원 탈퇴하기
//		System.out.println("============ 회원 탈퇴 하기 ============ ");
//		int deleteResult = session.delete("MemberMapper.deleteMember",pvo.getId());
//		session.commit();
//		if(deleteResult != 0 )	System.out.println(deleteResult+"명 탈퇴하셨습니다.");
//		else System.out.println("없는 회원입니다.");
		
		
		
		//6. id hahaha 존재하는지 확인?
		String searchId = "kblife";
		System.out.println("============ ID 존재 여부 ============ ");
		String exist = session.selectOne("MemberMapper.idExist", searchId);
		if(exist !=null)	System.out.println("ID : "+ exist);
		else System.out.println("존재하지 않는 ID 입니다.");
		
	}

}
