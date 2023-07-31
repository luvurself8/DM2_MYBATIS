package net.kd.cashbook.ui;

import java.util.List;
import java.util.Scanner;

import net.kd.cashbook.dao.CashbookDAO;
import net.kd.cashbook.vo.CashItem;



public class CashbookUI {
	Scanner keyin = new Scanner(System.in);
	CashbookDAO dao = new CashbookDAO();
	List<CashItem> itemList;

	public CashbookUI() {
		itemList = dao.selectCashItem();
		String choice;

		while(true) {
			mainMenu();
			choice = keyin.nextLine();

			switch(choice) {
			case "1" : input();  		break;
			case "2" : list();   		break;
			case "3" : delete(); 		break;
			case "4" : statistics(); 	break;
			case "0" : 
				System.out.println("** 프로그램을 종료합니다.");
				System.exit(0);
			default :
				System.out.println("err) 메뉴를 다시 선택해 주세요");
			}
		}
	}

	// 메인 메뉴
	private void mainMenu() {
		System.out.println("===== [ 지출 관리] =====");
		System.out.println("    1) 지출 내역 입력");
		System.out.println("    2) 지출 내역 조회");
		System.out.println("    3) 내역 삭제");
		System.out.println("    4) 지출 통계보기");
		System.out.println("    0) 프로그램 종료"); 
		System.out.println("======================");
		System.out.print  ("      선택> ");
	}

	// 지출 내역 입력
	private void input() {
		String itemid;
		String detail;
		int amount;
		String note;

		System.out.println("\n<< 지출 내역 입력 >>");

		printItemList();

		// Code Here
		
		int result = 0;

		System.out.println(result +"개의 항목이 저장되었습니다.");
	}

	// 지출 목록 출력
	private void printItemList() {
		// Code Here
		
		System.out.println();
	}

	// 지출 내역 조회
	private void list() {
		System.out.println("\n<< 월별 지출 보기 >>");

		String date = inputDate();
		if(date == null) {
			System.out.println("데이터가 잘못 입력되었습니다.");
			return;
		}
		//	Code Here
		
		
	}

	// 가계부 삭제
	private void delete() {
		int seq;
		String answer;
		int result = 0;
		
		System.out.println("\n<< 내역 삭제 >>");
		
		String date = inputDate();


		
		// Code here
		System.out.println(result +"개의 지출 내역이 삭제되었습니다.");
	}

	// 지출 통계보기
	private void statistics() {
		System.out.println("\n<< 지출 통계보기 >>");

		String date = inputDate();
		if(date == null) {
			System.out.println("데이터가 잘못 입력되었습니다.");
			return;
		}
		
		// Code here
	}
	
	// 년도와 월을 입력받는 메소드 
	// 입력받은 년도와 월을 YY/MM 과 같은 형식으로 만들어 리턴한다.
	// 년도와 월은 길이가 각각 2자리여야 한다.
	private String inputDate() {
		String year, month, date = null ;
		

		return date;
	}
}
