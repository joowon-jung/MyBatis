package mybatis.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;
import mybatis.service.user.UserService;

/*
 *  	회원관리 서비스 비지니스 로직을 추상화한 interface 구현
 *  	- Component : interface 로 Encapsulation 된 재사용가능한 library
 */
@Service("userServiceImpl14")
public class UserServiceImpl14 implements UserService {

	///Field
	@Autowired
	@Qualifier("userDaoImpl14")
	UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		System.out.println("::"+getClass()+".setUserDao Call....");
		this.userDao = userDao;
	}

	public UserServiceImpl14() {
		System.out.println("::"+getClass()+" default Constructor Call...");
	}
	
	@Override
	//==> 회원정보 :: INSERT ( 회원가입 )
	public int addUser(User user) throws Exception {
		////////////////////////////////////////////////////////
		////// AOP 를 이용한 Transaction 처리를 위해 수정한 부분 //////
		//return userDao.addUser(user);
		// Test 후 아래 주석처리하고 위에 부분 주석 풀어서 원상복귀 하자!
		////////////////////////////////////////////////////////
		int result = 0;
		System.out.println(">>>>>> 1번째 insert ==============");
		result = userDao.addUser(user);
		System.out.println(">>>>>> 1번째 insert : " + result);
		System.out.println(">>>>>> 2번째 insert ==============");
		result = userDao.addUser(user);
		System.out.println(">>>>>> 2번째 insert : " + result);
		System.out.println(">>>>>> 결과는 ???? ==============");
		
		return 0;
		////////////////////////////////////////////////////////
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
