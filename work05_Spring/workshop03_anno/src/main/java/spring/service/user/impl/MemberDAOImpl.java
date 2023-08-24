package spring.service.user.impl;
/*
 * Annotation 기반으로 작성
 * xml빈설정문서에서 bean태그를 생략할 수 있다.
 * 
 * <bean>
 * </bean>              @Component
 */
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	private SqlSession sqlSession;	
	public static final String MAPPER_NAME = "MemberMapper.";
	
	@Override
	public int registerMember(MemberVO member) throws Exception {
		int result = sqlSession.insert(MAPPER_NAME+"registerMember",member);
		return result;
	}
	@Override
	public int updateMember(MemberVO member) throws Exception {
		int result = sqlSession.update(MAPPER_NAME+"updateMember",member);
		return result;
	}
	@Override
	public int deleteMember(String id) throws Exception {
		int result = sqlSession.delete(MAPPER_NAME+"deleteMember",id);
		return result;
	}
	@Override
	public MemberVO getMember(String id) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"getMember",id);
	}
	@Override
	public List<MemberVO> showAllMember(MemberVO member) throws Exception {
		return sqlSession.selectList(MAPPER_NAME+"showAllMember",member);
	}

	public String login(MemberVO member) throws Exception {
		return sqlSession.selectOne(MAPPER_NAME+"login",member);
	}

	
}
