package net.kdigital.fitness.dao;

import java.util.List;

import net.kdigital.fitness.vo.Fitness;

public interface FitnessMapper {
	
	/**
	 * 회원정보객체를 전달받아 Array에 저장 
	 * @param fitness
	 * @return 저장을 잘했으면 true, 실패하면 false
	 */
	public boolean insert(Fitness fitness);
	
	/**
	 * 회원의 PK정보를 전달받아 검색된 회원정보 반환 
	 * @param id 회원의 pk
	 * @return 검색된 회원 객체, 검색 못할 경우 null 반환  
	 */
	public Fitness selectOne(String id); 
	
	/**
	 * 수정하고자 하는 회원정보를 객체로 받아 수정 실시 
	 * @param fitness 수정하고자 하는 회원 객체 
	 * @return 수정 성공시 true, 실패시 false 
	 */
	public boolean update(Fitness fitness); 
	
	/**
	 * 회원 정보 삭제 
	 * @param id 삭제하고자 하는 회원의 ID
	 * @return 삭제 성공 시 true, 실패 시 false 
	 */
	public boolean delete (String id);
	
	/**
	 * 전체 회원 정보 조회 
	 * @return 모든 회원의 정보가 저장된 배열 
	 */
	public  List<Fitness> selectAll();
	
	
}
