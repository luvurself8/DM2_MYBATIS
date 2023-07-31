package net.kd.cashbook.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;



public class CashbookDAO {

	private SqlSessionFactory factory = MybatisConfig.getSqlSessionFactory(); // 마이바티스 객체

	// CashItem 전체 조회
	public List<CashItem> selectCashItem() {
		// Code here
		
		return null;
	}
	
	// 지출 내역 입력
	public int insertCashbook(Cashbook book) {
		// Code Here
		
		
		int result = 0;
		return result;
	}
	
	// 년+월별 지출 내역 확인
	public List<Cashbook> ReadCashbookByDate(String date) {
		// Code Here
		
		
		return null;
	}
	
	// 내역 삭제
	public int deleteCashbook(int seq) {
		// Code Here
		
		
		int result = 0;
		return result;
	}
	
	// 지출 통계 조회
	public List<TotalAmount> statatics(String date) {


		return null;
	}
}
