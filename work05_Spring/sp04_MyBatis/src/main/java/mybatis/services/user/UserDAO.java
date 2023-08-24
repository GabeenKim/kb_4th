package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

//template 기능...
//mybatis-userservice-mapping10.xml의 태그 id 값이 template 기능의 이름이 된다. 
//쿼리문 태그의 parameterType이 tamplate 기능의 인자값이 되며
///쿼리문 태그의 resultType or resultMap이 tamplate 기능의 리턴 타입과 연결된다.

public interface UserDAO {
	int addUser(User user) throws Exception;
	int updateUser(User user) throws Exception;
	int removeUser(String userId) throws Exception;
	
	User getUser(String userId)throws Exception;
	List<User> getUserList(User user) throws Exception;
}
