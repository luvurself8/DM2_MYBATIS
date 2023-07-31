package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import vo.User;

public class UserMapper {
	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory();
	
	public boolean insert(User user) {
		SqlSession session = null;
		
		session = factory.openSession();
		UserDAO dao = session.getMapper(UserDAO.class); // UserDAO를 통해 실제 쿼리문이 있는 매퍼와 연동됨
	
		int result = dao.insertUser(user);
		
		session.commit();
		
		if(result == 0) return false;
		return true;
	}
	
	public User selectOne(String userid) {
		SqlSession session = null;
		session = factory.openSession();
		UserDAO dao = session.getMapper(UserDAO.class);
		
		User user = dao.selectOne(userid);
		return user;		
	}
	
	public List<User> selectAll() {
		SqlSession session = null;
		session = factory.openSession();
		UserDAO dao = session.getMapper(UserDAO.class);
		
		List<User> list = dao.selectAll();
		
		return list;	
	}
}

