package mybatis.services.user;

import java.util.List;

import mybatis.services.domain.User;

public interface UserService {
	void addUser(User user) throws Exception;
	void updateUser(User user) throws Exception;
	
	//원래는 얘네만 있어도 됨 
	User getUser(String userId)throws Exception;
	List<User> getUserList(User user) throws Exception;
}
