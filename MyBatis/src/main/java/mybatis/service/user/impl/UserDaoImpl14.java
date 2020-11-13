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
 * 	데이터베이스와 직접적인 통신을 담당하는 퍼시스턴스 계층을 담당할 UserDao 인터페이스 구현
 */

@Repository("userDaoImpl14") // DAO 안에 데이터가 담겨있으니까! 저장소라고 생각하기 
public class UserDaoImpl14 implements UserDao {

	///Field
	@Autowired // setter method를 찾아서 wiring 수행
	@Qualifier("sqlSessionTemplate") // setter method 지정 (여기서는 setSqlSession("sqlSessionTemplate")) 
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		System.out.println("::"+getClass()+".setSqlSession() Call....");
		this.sqlSession = sqlSession;
	}
	
	public UserDaoImpl14() {
		System.out.println("::"+getClass()+" default Constructor Call....");
	}

	@Override
	//==> 회원정보 :: INSERT ( 회원가입 )
	public int addUser(User user) throws Exception {
		return sqlSession.insert("UserMapper10.addUser", user);
	}

	@Override
	//==> 회원정보 :: SELECT ( 회원가입 검색 )
	public User getUser(String userId) throws Exception {
		return (User)sqlSession.selectOne("UserMapper10.getUser", userId);
	}

	@Override
	//==> 회원정보 :: UPDATE ( 회원정보 변경 )
	public int updateUser(User user) throws Exception {
		return sqlSession.update("UserMapper10.updateUser", user);
	}

	@Override
	//==> 회원정보 :: DELETE ( 회원정보 삭제 )
	public int removeUser(String userId) throws Exception {
		return sqlSession.delete("UserMapper10.removeUser", userId);
	}

	@Override
	//==> 회원정보 :: SELECT ( 모든 회원 정보 검색 )
	public List<User> getUserList(Search search) throws Exception {
		return sqlSession.selectList("UserMapper10.getUserList", search);
	}

}
