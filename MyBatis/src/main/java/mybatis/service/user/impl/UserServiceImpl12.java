package mybatis.service.user.impl;

import java.util.List;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;
import mybatis.service.user.UserService;

/*
 *  	ȸ������ ���� �����Ͻ� ������ �߻�ȭ�� interface ����
 *  	- Component : interface �� Encapsulation �� ���밡���� library
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
	//==> ȸ������ :: INSERT ( ȸ������ )
	public int addUser(User user) throws Exception {
		return userDao.addUser(user);
	}

	@Override
	//==> ȸ������ :: SELECT ( ȸ�������� �˻� )
	public User getUser(String userId) throws Exception {
		return userDao.getUser(userId);
	}

	@Override
	//==> ȸ������ :: UPDATE ( ȸ������ ���� )
	public int updateUser(User user) throws Exception {
		return userDao.updateUser(user);
	}

	@Override
	//==> ȸ������ :: DELETE ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception {
		return userDao.removeUser(userId);
	}

	@Override
	//==> ȸ������ :: SELECT ( ȸ�� ���� �˻� )
	public List<User> getUserList(Search search) throws Exception {
		return userDao.getUserList(search);
	}

}
