package ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import dao.UserMapper;
import vo.User;

public class UserUI {
	Scanner keyin = new Scanner(System.in);
	UserMapper mapper = new UserMapper();
	
	
	public UserUI() {
		String choice;
		
		while(true) {
			menu();
			choice = keyin.next();
			
			switch(choice) {
			case "1" : 
				join();
				break;
			case "2" :
				retrieve();
				break;
			case "3" :
				retrieveAll();
				break;
			case "0" :
				keyin.close();
				System.out.println("** 프로그램을 종료합니다.");
				return;
			default :
				System.out.println("** 메뉴를 다시 선택해주시오");
			}
		}
	}


	private void join() {
		System.out.println("\n== [회원 가입] ==");
		String userid, username, gender, phone, birthday;
		
		System.out.print("> 아이디: ");
		userid = keyin.next();
		
		User user = mapper.selectOne(userid);
		if(user != null) {
			System.out.println("err> 중복된 아이디입니다.");
			return;
		}
		
		System.out.print("> 이  름: ");
		username = keyin.next();
		
		System.out.print("> 성별(남/여): ");
		gender = keyin.next();

		System.out.print("> 전화번호: ");
		phone = keyin.next();

		System.out.print("> 생년월일(yy/mm/dd): ");
		birthday = keyin.next();
		
		boolean result =mapper.insert(new User(userid, username, gender, phone, birthday));

		if(result) {
			System.out.println("** 회원 가입 완료");
			return;
		}
		System.out.println("** 서버의 오류로 인하여 회원가입이 실패되었습니다.");
		System.out.println("   잠시후 다시 시도해주세요");
	}


	private void retrieve() {
		System.out.println("\n== [회원 정보 조회] ==");
		String userid;
		
		System.out.print("> 아이디: ");
		userid = keyin.next();
		
		User user = mapper.selectOne(userid);
		if(user != null) {
			System.out.println(user);
			return;
		}
		System.out.println("err> 입력한 아이디의 회원정보는 존재하지 않습니다.");
	}


	private void retrieveAll() {
		System.out.println("\n== [전체 회원 조회] ==");

		List<User> list = mapper.selectAll();
		
		Iterator<User> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}


	private void menu() {
		System.out.println("\n=========================");
		System.out.println("      [ 회원 관리 ]");
		System.out.println("=========================");
		System.out.println("       1. 회원 가입");
		System.out.println("       2. 회원 정보 조회");
		System.out.println("       3. 전체 회원 조회");
		System.out.println("       0. 종    료");
		System.out.println("=========================");
		System.out.print  ("         > 선택: ");
	}
}
