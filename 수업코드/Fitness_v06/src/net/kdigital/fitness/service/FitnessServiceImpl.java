package net.kdigital.fitness.service;

import java.util.List;

import net.kdigital.fitness.dao.FitnessDAO;
import net.kdigital.fitness.dao.FitnessDAOImpl;
import net.kdigital.fitness.vo.Fitness;

public class FitnessServiceImpl implements FitnessService {
	
//	List<Fitness> list = new ArrayList<>(); 
	FitnessDAO dao = new FitnessDAOImpl();
	
	@Override
	public boolean insert(Fitness fitness) {  //인서트 할 수 있도록 dao로 넘겨줘야함 

		boolean result = dao.insert(fitness);
		return result;  
	}

	@Override
	public Fitness selectOne(String id) { 

		Fitness fitness = dao.selectOne(id);
		return fitness; 
	}

	@Override
	public boolean update(Fitness fitness) {

		boolean result = dao.update(fitness); 
		return result; 
	}

	@Override
	public boolean delete(String id) {

		boolean result = dao.delete(id);
		return result;
	}

	@Override
	public List<Fitness> selectAll() {
		List<Fitness> list = dao.selectAll();
		return list;
	}

	
}
