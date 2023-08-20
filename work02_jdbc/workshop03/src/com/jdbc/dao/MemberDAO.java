package com.jdbc.dao;

import java.util.ArrayList;
import com.jdbc.dto.Member;

public interface MemberDAO {
	void insertMember(Member member) throws Exception;
	void deleteMember(int id) throws Exception;
	void updateMember(Member member) throws Exception;
	Member getMember(int id) throws Exception;
	ArrayList<Member> getMember() throws Exception;
	ArrayList<Member> getMember(String name) throws Exception;
}