package spring.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import spring.service.domain.MemberVO;
import spring.service.user.MemberDAO;
import spring.service.user.MemberService;

@Service
public class MemberDAOServiceImpl implements MemberService{
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public void registerMember(MemberVO member) throws Exception {
		memberDAO.registerMember(member);	
		
	}

	@Override
	public void updateMember(MemberVO member) throws Exception {
		memberDAO.updateMember(member);	
		
	}

	@Override
	public MemberVO getMember(String id) throws Exception {
		return memberDAO.getMember(id);
	}

	@Override
	public List<MemberVO> showAllMember(MemberVO member) throws Exception {
		return memberDAO.showAllMember(member);
	}

	@Override
	public boolean login(MemberVO member) throws Exception {
		String name = memberDAO.login(member);
		if(name!=null) return true;
		else return false ;

	}	
	
	

}
