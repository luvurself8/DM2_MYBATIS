package net.kd.school.ui;

import java.util.List;
import java.util.Scanner;

import net.kd.school.dao.ScoreDAO;
import net.kd.school.dao.StudentDAO;
import net.kd.school.vo.ScoreVO;
import net.kd.school.vo.StudentVO;
import net.kd.school.vo.Total;


public class StudentUI {
	private StudentDAO stdDao = new StudentDAO();
	private ScoreDAO scoreDao = new ScoreDAO();	 

	private Scanner keyin = new Scanner(System.in); 

	public StudentUI() {

		while(true) {
			printMainMenu();
			String choice = null;
			choice = keyin.nextLine();

			switch(choice){
			case "1":  
				stdInsert();
				break;

			case "2": 
				scoreInsert();
				break;
				
			case "3": 
				stdDelete();
				break;

			case "4": 
				selectAll();
				break;


			case "0": 
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);

			default:
				System.out.println("번호를 다시 선택하세요.");
			}
		}
	}

	// 메인 메뉴
	private void printMainMenu(){
		System.out.println(" [ 학생 성적 관리 ]");
		System.out.println("  1. 학생 등록");
		System.out.println("  2. 성적 입력");
		System.out.println("  3. 정보 삭제");
		System.out.println("  4. 전체 성적 보기");
		System.out.println("  0. 프로그램 종료");
		System.out.println("===================");
		System.out.print  (" * 번호를 선택하세요 > ");	
	}

	// 학생 등록
	private void stdInsert() {
		String stnum;				//학생 구분번호
		String stclass;				//반
		String stname;				//이름

		System.out.println("[ 학생 등록 ]");

		System.out.print("> 학생 번호 : ");
		stnum = keyin.nextLine();
		
		StudentVO std = stdDao.findByNum(stnum);
		if(std != null) {
			System.out.println("** 이미 등록된 학생 정보가 존재합니다..");
			return;
		}

		System.out.print("> 반 (A, B, C) : ");
		stclass = keyin.nextLine();

		if(!(stclass.toUpperCase().charAt(0) >= 'A' && stclass.toUpperCase().charAt(0) <= 'C') || stclass.length() != 1) {
			System.out.println("** 반은 A~C까지 하나의 문자로 입력해 주세요.");
			return;
		}
		System.out.print("> 이름 : ");
		stname = keyin.nextLine(); 

		StudentVO s = new StudentVO(stnum, stclass.toUpperCase(), stname);

		int result = stdDao.insertStudent(s);

		if (result != 0) {
			System.out.println("** 학생 정보가 저장되었습니다.");
		}
		else {
			System.out.println("** 저장 실패하였습니다.");
		}
	}

	// 성적 입력
	private void scoreInsert() {
		String stnum;			//학생 번호
		int java;				//java과목 점수
		int sql;				//sql과목 점수
		int spring;				//spring과목 점수
		
		System.out.println("[ 성적 입력 ]");

		System.out.print("> 학생 번호 : ");
		stnum = keyin.nextLine();
		
		// 해당하는 번호의 학생 정보를 가져온다
		StudentVO std = stdDao.findByNum(stnum);
		if(std == null) {
			System.out.println("** 학생 정보가 없습니다.");
			return;
		}
		System.out.println(std);
		
		try {
			System.out.print("> Java 성적 : ");
			java = keyin.nextInt();
			
			System.out.print("> SQL 성적 : ");
			sql = keyin.nextInt();
			
			System.out.print("> Spring 성적 : ");
			spring = keyin.nextInt();  keyin.nextLine();
		
		} catch (Exception e) {
			System.out.println("err> 성적은 정수로 입력해 주세요");
			keyin.nextLine();
			return;
		}
		
		ScoreVO vo = new ScoreVO(stnum, java, sql, spring);
		
		int result = scoreDao.scoreInsert(vo);
		
		if (result != 0) {
			System.out.println("** 학생의 성적이 저장되었습니다.");
		}
		else {
			System.out.println("** 저장 실패하였습니다.");
		}
	}
	
	// 학생 정보 삭제
	private void stdDelete() {
		String stnum;			//학생 번호
		String answer;
		System.out.println("[ 정보 삭제 ]");

		System.out.print("> 학생 번호 : ");
		stnum = keyin.nextLine();
		
		// 해당하는 번호의 학생 정보를 가져온다
		StudentVO std = stdDao.findByNum(stnum);
		if(std == null) {
			System.out.println("** 학생의 정보가 존재하지 않습니다.");
			return;
		}
		System.out.println(std);
		
		System.out.print("** 위 학생의 정보를 삭제하시겠습니까? (y/n)");
		answer = keyin.nextLine();
		
		if(!answer.equals("y")) {
			System.out.println("** 취소되었습니다.");
			return;
		}
		
		int result = stdDao.deleteStudent(stnum);
				
		if (result != 0) {
			System.out.println("** 정보가 삭제되었습니다.");
		}
		else {
			System.out.println("** 삭제 실패하였습니다.");
		}
	}
	
	// 전체 학생 성적 조회
	private void selectAll() {
		System.out.println("[ 전체 성적 보기 ]");

		// 해당하는 번호의 학생 정보를 가져온다
		List<Total> list = scoreDao.scoreList();
		if(list.isEmpty()) {
			System.out.println("** 등록된 성적이 없습니다.");
			return;
		}
		for(int i=0; i<list.size(); ++i) {
			int total = list.get(i).getJava() +list.get(i).getSql() + list.get(i).getSpring();
			list.get(i).setTotal(total);
		}
		list.forEach(x -> System.out.println(x));
		System.out.println();
	}
}
