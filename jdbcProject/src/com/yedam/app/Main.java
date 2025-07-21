package com.yedam.app;

import java.util.ArrayList;
import java.util.Scanner;

// 사용자 입력 -> DB 반영
// DB 결과 -> 콘솔 출력
// 컨트롤 역할
public class Main {

	public static void main(String[] args) {
		boolean run = true; // 반복조건에 사용
		Scanner scn = new Scanner(System.in);
		BookDAO dao = new BookDAO(); // 조회
		
		while(run) {
			System.out.println("도서 관리 시스템");
			System.out.println("1. 도서 목록");			
			System.out.println("2. 도서 등록");			
			System.out.println("3. 도서 수정");			
			System.out.println("4. 도서 삭제");			
			System.out.println("9. 종료");			
			System.out.print("선택 : ");
			int menu = scn.nextInt(); // 입력값을 menu 변수에 대입(할당)
			switch (menu) {
			case 1 : // 도서 목록
				ArrayList<Book> list = dao.findAll(); // 반환 : ArrayList<Book>
				System.out.println("도서번호  도서명       저자    가격");
				System.out.println("============================");
				for(int i = 0; i < list.size(); i++) {
					System.out.println(list.get(i).getId() 
							+ " " + list.get(i).getTitle()
							+ " " + list.get(i).getAuthor()
							+ " " + list.get(i).getPrice());
				}
				break;
			case 2 : // 도서 등록
				break;
			case 3 : // 도서 수정
				break;
			case 4 : // 도서 삭제
				break;
			case 9 : // 종료
				run = false;
			}
		} // end while
		
		System.out.println("end of program");
	}// end main

}// end class