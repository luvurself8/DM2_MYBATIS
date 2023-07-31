package net.kdigital.fitness.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kdigital.fitness.vo.Fitness;

public class FitnessDAOImpl implements FitnessDAO {
	
	private SqlSessionFactory  factory = MybatisConfig.getSqlSessionFactory();
	
	@Override
	public boolean insert(Fitness fitness) {
		SqlSession session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		
		boolean result = mapper.insert(fitness);
		session.commit();
		
		return result;
	}

	@Override
	public Fitness selectOne(String id) {
		SqlSession session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		
		return mapper.selectOne(id);
	}

	@Override
	public boolean update(Fitness fitness) {
		SqlSession session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		
		boolean result = mapper.update(fitness);
		session.commit();
		return result;

	}

	@Override
	public boolean delete(String id) {
		SqlSession session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);

		boolean result = mapper.delete(id);
		session.commit();
		return result;

	}

	@Override
	public List<Fitness> selectAll() {
		SqlSession session = factory.openSession();
		FitnessMapper mapper = session.getMapper(FitnessMapper.class);
		return mapper.selectAll();
	}
	// 데이터 베이스에 연결하는 작업 
	

}
