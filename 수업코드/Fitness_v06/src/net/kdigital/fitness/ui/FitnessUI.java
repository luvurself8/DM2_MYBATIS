package net.kdigital.fitness.ui;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import net.kdigital.fitness.service.FitnessService;
import net.kdigital.fitness.service.FitnessServiceImpl;
import net.kdigital.fitness.vo.Fitness;


public class FitnessUI {
	Scanner keyin = new Scanner (System.in);
	
	// 부모 참조 변수가 자식 클래스를 참조하고있다. //각 소스파일이 가지고 있어야하는것이 다르니 주의할 것 
	FitnessService service = new FitnessServiceImpl(); // 다형성 
	
	public FitnessUI() {
		String choice; 
		while(true) {
			menu();
			choice = keyin.next();
			switch (choice) {
			case "1" : creat(); break;
			case "2" : retrieve(); break;
			case "3" : modify(); break;
			case "4" : delete(); break;
			case "5" : selectAll(); break;
			case "0" : 
				System.out.println("** 프로그램을 종료합니다.");
				keyin.close();
				return; 
			default :
				System.out.println("err> 메뉴를 다시 선택해주세요");
			}
		}
	}
	
	private void creat() {
		System.out.println("\n[ 회원가입 ]");
		
		String id;
		String name; 
		double height;
		double weight;
		
		
		System.out.print("** 회원ID를 입력하세요:");
		id = keyin.next();
		
		//아이디 중복체크 
		Fitness fitness = service.selectOne(id); // 서비스로 입력받은 아이디를 보내고 피트니스를 넘겨받는다. 
		if (fitness != null) {
			System.out.println("err> 회원아이디 중복! 다시 입력하세요.\n");
			return;
		}
		try {
		System.out.print("** 회원이름을 입력하세요:");
		name = keyin.next();
		
		System.out.print("** 키(cm)를 입력하세요:");
		height = keyin.nextDouble();
		
		System.out.print("** 몸무게(kg)를 입력하세요:");
		weight = keyin.nextDouble(); 
		} catch (Exception e) {
			System.out.println("err> 키와 몸무게는 숫자로 입력해주세요");
			keyin.nextLine(); // 문자열일경우 입력버퍼에 남아있음으로 지워쥬쟈 
			return;
		}
		
		boolean result = service.insert(new Fitness(id, name, height, weight)); // 객체를 생성하자마자 서비스의 인서트 함수로 보낸다. 
		
		if (result) // service의 insert함수가 true false 반환한다 
			System.out.println("** 회원가입이 완료되었습니다.");
		else 
			System.out.println("** 회원가입 실패");
		
	}

	private void retrieve() {
		System.out.println("\n[ 회원조회 ]");
		String id;
		
		System.out.print("** 회원ID를 입력하세요:");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness == null) {
			System.out.println("** 조회하신 정보가 없습니다.");
			return;
		}
		System.out.println(fitness);
		
	}

	private void modify() {
		System.out.println("\n[ 정보수정 ]");
		String id;
		double height;
		double weight;
		
		// 회원을 찾는 용도 
		System.out.print("** 회원ID를 입력하세요:");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness == null) {
			System.out.println("err> 입력하신 회원의 정보가 없습니다.");
			return;
		}
		
		try {
		System.out.print("** 키(cm)를 입력하세요:");
		height = keyin.nextDouble();
		
		System.out.print("** 몸무게(kg)를 입력하세요:");
		weight = keyin.nextDouble();
		
		} catch (Exception e) {
			System.out.println("err> 키와 몸무게는 숫자로 입력해주세요");
			keyin.nextLine();
			return;
		}
		
		boolean result = service.update(new Fitness(id, null, height, weight)); // 객체를 생성해서 바로 함수에 넣는다. 
		
		if (result) System.out.println("** 회원의 정보가 수정되었습니다.");
		else System.out.println("** 회원정보 수정 실패");

		
	}

	private void delete() {
		System.out.println("\n[ 회원탈퇴 ]");
		
		String id;
		String answer; // 뎡말뎡말 탈퇴할건지 물어보는 거 
		
		System.out.print("** 회원ID를 입력하세요:");
		id = keyin.next();
		
		Fitness fitness = service.selectOne(id);
		
		if (fitness == null) {
			System.out.println("** 입력하신 회원이 없습니다.");
			return;
		}
		System.out.print(" ** 뎡말...나갈 건가요? (y/n)");
		answer = keyin.next();
		
		if (!answer.equals("y")) {
			System.out.println("탈퇴 작업이 취소되었습니다.");
			return;
		}
		
		boolean result = service.delete(id);
		
		if (result) System.out.println("** 회원 탈퇴가 완료되었습니다.");
		else System.out.println("** 회원 탈퇴에 실패하였습니다. ");
			}
			


	private void selectAll() {
		System.out.println("\n[ 전체회원조회 ]");
		
		
		List<Fitness> list =  service.selectAll(); // 피트니스 전체 회원 목록  
		
		if (list.size() == 0) {
			System.out.println("** 가입한 회원이 한명도 없습니다.");
			return;
		}
		
		Iterator<Fitness> iter = list.iterator();
		
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
	}

	public void menu() {
		System.out.println("=============[ 가금 피트니스 회원 관리 ] ===============");
		System.out.println("==============[ 1.  회    원   가    입   ] ================");
		System.out.println("==============[ 2.  회    원   조    회   ] ================");
		System.out.println("==============[ 3.  정    보   수    정   ] ================");
		System.out.println("==============[ 4.  회    원   탈    퇴   ] ================");
		System.out.println("==============[ 5.  전 체  회 원 조  회 ] ================");
		System.out.println("==============[ 0.  종                   료 ] ================");
		System.out.println("================================================");
		System.out.print("                                선택 > ");
	}
	
}
