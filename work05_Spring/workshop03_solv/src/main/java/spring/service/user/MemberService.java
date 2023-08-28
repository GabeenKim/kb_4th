package spring.service.user;

import java.util.List;

import spring.service.domain.MemberVO;

/*
 *	데이터 가공과 관련된 레이어...
 *	게시판 페이징 처리 로직 or 통계관련 로직(랭킹 등), 알고리즘 연결 로직 등 
 *	원래 서비스는 셀렉트 문만 작성해주는 것이긴 하나 다 집어넣을 때도 ㅣㅇ씅ㅁ..
 */
public interface MemberService {
	
	MemberVO getMember(String id)throws Exception;
	List<MemberVO> showAllMember()throws Exception;
	
	String idExist(String id) throws Exception;
	String login(MemberVO member) throws Exception;
}
