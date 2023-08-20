package com.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.exception.DuplicateIDException;
import com.jdbc.exception.RecordNotFoundException;
import com.jdbc.vo.Member;

public interface MemberDAO {
	void insertMember(Member member) throws DuplicateIDException, SQLException ;
	void deleteMember(int id) throws RecordNotFoundException, SQLException;
	void updateMember(Member member) throws RecordNotFoundException, SQLException;
	Member getMember(int id) throws RecordNotFoundException, SQLException;
	ArrayList<Member> getMember() throws RecordNotFoundException, SQLException;
	ArrayList<Member> getMember(String name) throws RecordNotFoundException, SQLException;
}