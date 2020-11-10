package mybatis.service.user.impl;

import java.util.List;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;
import mybatis.service.user.UserService;

/*
 *  	회원관리 서비스 비지니스 로직을 추상화한 interface 구현
 *  	- Component : interface 로 Encapsulation 된 재사용가능한 library
 */
public class UserServiceImpl12 implements UserService {

	///Field
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		System.out.println("::"+getClass()+".setUserDao Call....");
		this.userDao = userDao;
	}

	public UserServiceImpl12() {
		System.out.println("::"+getClass()+" default Constructor Call...");
	}
	
	@Override
	//==> 회원정보 :: INSERT ( 회원가입 )
	public int addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	@Override
	//==> 회원정보 :: SELECT ( 회원정보를 검색 )
	public User getUser(String userId) throws Exception {
		return userDao.getUser(userId);
	}

	@Override
	//==> 회원정보 :: UPDATE ( 회원정보 변경 )
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	//==> 회원정보 :: DELETE ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception {
		return userDao.removeUser(userId);
	}

	@Override
	//==> 회원정보 :: SELECT ( 회원 정보 검색 )
	public List<User> getUserList(Search search) throws Exception {
		return userDao.getUserList(search);
	}

}
