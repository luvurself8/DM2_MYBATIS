package dao;

import java.util.List;

import vo.User;

public interface UserDAO {
	/**
	 * 회원정보 저장
	 * @param user
	 * @return 저장 여부(1: 1명이 등록, 0: 등록안됨)
	 */
	
	public int insertUser(User user);
	/**
	 * 회원 전체 정보 조회
	 * @return 목록(List)에 담긴 모든 회원의 정보
	 */

	public List<User> selectAll();
	
	/**
	 * 한 사람의 회원 정보 조회
	 * @param userid : 조회할 회원의 아이디(PK)
	 * @return 회원의 정보가 담긴 User객체, 조회가 안될경우 null 반환
	 */
	public User selectOne(String userid);
}
/*
SELECT 
	USERID, USERNAME, GENDER, PHONE, 
	to_char(BIRTHDAY, 'YYYY-MM-DD') AS BIRTHDAY
FROM userinfo
ORDER BY username
*/








