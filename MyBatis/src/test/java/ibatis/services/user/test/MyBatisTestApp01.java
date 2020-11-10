package ibatis.services.user.test;

import java.io.Reader;
import java.util.List;

import mybatis.service.domain.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisTestApp01 {
	
	///main method
	public static void main(String[] args) throws Exception{
		
		//==> mybatis-config.xml : MyBatis Framework 의 핵심 MetaData
		//==> UserMapper.xml : SQL 를 갖는 MetaData 
		
		//==> 1. xml metadata 읽는 Stream 생성
		Reader reader = Resources.getResourceAsReader("sql/mybatis-config01.xml");
		
		//==> 2. Reader 객체를 이용 xml metadata 에 설정된 각종 정보를 접근, 사용가능한 
		//==>     SqlSession을 생성하는 SqlSessionFactory  instance 생성
		SqlSessionFactory sqlSessionFactory 
											= new SqlSessionFactoryBuilder().build(reader);
		
		// ==> 3. SqlSessionFactory를 통해 autoCommit true 인 SqlSession instance 생성 
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		System.out.println("\n");
		
		//0. getUserList :: 모든 user 정보 
		System.out.println(":: 0. all User(SELECT) ? ");
		List<User> list01 = sqlSession.selectList("UserMapper01.getUserList");
		for (int i = 0; i < list01.size(); i++) {
			System.out.println("<" + (i+1) + "> 번째 회원.." + list01.get(i).toString());
		}
		System.out.println("\n");
		
		//1. getUser :: 특정 userId 정보
		User user = (User)sqlSession.selectOne("UserMapper01.getUser", "user01");
									// selectOne : 한 줄이 리턴됨 ("", "파라미터 값")
		System.out.println(":: 1. get (SELECT) ? " + user.toString());
		System.out.println("\n");
		
		//2. findUserId :: 특정 userId / password 정보 
		user.setUserId("user03");
		user.setPassword("user03");
		String name = (String) sqlSession.selectOne("UserMapper01.findUserId", user);
		System.out.println(":: 2. get (SELECT) ? " + name);
		System.out.println("\n");
		
		//3. getUserListAge :: 특정 age 정보 
		System.out.println(":: 3. 특정 조건 User(SELECT) ? ");
		List<String> list02 
				= sqlSession.selectList("UserMapper01.getUserListAge", new Integer(20));
		for (int i = 0; i < list02.size(); i++) {
			System.out.println("<" + (i+1) + "> 번째 회원.." + list02.get(i).toString());
		}
		System.out.println("\n");
		
		// END :: SqlSession close 
		System.out.println(":: END :: SqlSession 닫기");
		sqlSession.close();
	}// end of main
}//end of class
