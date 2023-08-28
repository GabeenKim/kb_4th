package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

/*
 *  -mapping.xml에서 쿼리문 id 값이 해당 인터페이스 기능의 이름이 된다.
 */
public interface MemberDAO {
	int registerMember(MemberVO member) throws Exception;
	int updateMember(MemberVO member) throws Exception;
	int deleteMember(String id) throws Exception;
	
	MemberVO getMember(String id)throws Exception;
	List<MemberVO> showAllMember()throws Exception;
	
	String idExist(String id) throws Exception;
	String login(MemberVO member) throws Exception;
}
