package net.kd.school.dao;


import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kd.school.vo.StudentVO;

public class StudentDAO {

	
	/**
	 * 학생 등록
	 * @param vo 등록할 학생 정보
	 * @return 저장된 행 수
	 */
	public int insertStudent(StudentVO vo) {
		
		


		
		return 0;
	}
	
	/**
	 * 1명의 학생 정보 조회
	 * @param stnum 조회할 학생 번호
	 * @return 학생 정보
	 */
	public StudentVO findByNum(String stnum) {
		
		
		
		
		
		return null;
	}
	
	/**
	 * 학생 정보 삭제
	 * @param stnum 삭제할 학생 번호
	 * @return 삭제된 행 수 
	 */
	public int deleteStudent(String stnum) {

		
		
		
		
		
		return 0;
	}
}