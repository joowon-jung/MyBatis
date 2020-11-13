package mybatis.service.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import mybatis.service.domain.Search;
import mybatis.service.domain.User;
import mybatis.service.user.UserDao;

/*
 * 	�����ͺ��̽��� �������� ����� ����ϴ� �۽ý��Ͻ� ������ ����� UserDao �������̽� ����
 */

@Repository("userDaoImpl14") // DAO �ȿ� �����Ͱ� ��������ϱ�! ����Ҷ�� �����ϱ� 
public class UserDaoImpl14 implements UserDao {

	///Field
	@Autowired // setter method�� ã�Ƽ� wiring ����
	@Qualifier("sqlSessionTemplate") // setter method ���� (���⼭�� setSqlSession("sqlSessionTemplate")) 
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession() Call....");
		this.sqlSession = sqlSession;
	}
	
	public UserDaoImpl14() {
		System.out.println("::"+getClass()+" default Constructor Call....");
	}

	@Override
	//==> ȸ������ :: INSERT ( ȸ������ )
	public int addUser(User user) throws Exception {
		return sqlSession.insert("UserMapper10.addUser", user);
	}

	@Override
	//==> ȸ������ :: SELECT ( ȸ������ �˻� )
	public User getUser(String userId) throws Exception {
		return (User)sqlSession.selectOne("UserMapper10.getUser", userId);
	}

	@Override
	//==> ȸ������ :: UPDATE ( ȸ������ ���� )
	public int updateUser(User user) throws Exception {
		return sqlSession.update("UserMapper10.updateUser", user);
	}

	@Override
	//==> ȸ������ :: DELETE ( ȸ������ ���� )
	public int removeUser(String userId) throws Exception {
		return sqlSession.delete("UserMapper10.removeUser", userId);
	}

	@Override
	//==> ȸ������ :: SELECT ( ��� ȸ�� ���� �˻� )
	public List<User> getUserList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper10.getUserList", search);
	}

}
