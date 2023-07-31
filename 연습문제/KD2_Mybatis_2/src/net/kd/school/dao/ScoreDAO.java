package net.kd.school.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import net.kd.school.vo.ScoreVO;
import net.kd.school.vo.StudentVO;
import net.kd.school.vo.Total;


public class ScoreDAO {

	/**
	 * 성적 등록
	 * @param vo 등록할 성적 정보
	 * @return 저장된 행 수
	 */
	public int scoreInsert(ScoreVO vo) {
		
		return 0;
	}
	
	/**
	 * 전체 성적 보기
	 * @return 모든 학생의 성적 정보
	 */
	public List<Total> scoreList() {

		
		
		return null;
	}
}