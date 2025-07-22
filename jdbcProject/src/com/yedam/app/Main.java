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
			System.out.println("5. 도서 단건 조회");			
			System.out.println("9. 종료");			
			System.out.print("선택 : ");
			int menu = scn.nextInt(); // 입력값을 menu 변수에 대입(할당)
			switch (menu) {
			case 1 : // 도서 목록
				ArrayList<Book> list = dao.findAll(); // 반환 : ArrayList<Book>
				System.out.printf("%-8s  %-11s  %-13s  %s\n", "도서번호", "도서명", "저자", "가격");
				System.out.println("================================================");
				for(int i = 0; i < list.size(); i++) {
					System.out.printf("%-10d  %-10s  %-10s  %8d\n",
							list.get(i).getId(),
							list.get(i).getTitle(),
							list.get(i).getAuthor(),
							list.get(i).getPrice());
				}
				break;
				
				//nextInt -> 1003엔터 -> 값만 읽음 엔터 처리 안 됨 
			case 2 : // 도서 등록
				System.out.print("도서 번호 >> ");
				int bno = scn.nextInt();scn.nextLine();
				System.out.print("도서 제목 >> ");
				String title = scn.nextLine();
				System.out.print("도서 저자 >> ");
				String author = scn.nextLine();
				System.out.print("도서 가격 >> ");
				int price = scn.nextInt();scn.nextLine();
				
				Book book = new Book(bno, title, author, price);
				if(dao.insert(book)) {
					System.out.println("정상 등록");
				} else {
					System.out.println("등록 중 오류");
				}
				break;
				
			case 3 : // 도서 수정
				System.out.print("수정할 도서 번호를 입력하시오 >> ");
				bno = scn.nextInt();scn.nextLine();
				System.out.print("수정할 가격을 입력하시오 >> ");
				price = scn.nextInt();scn.nextLine();
				
				if(dao.update(bno, price)) {
					System.out.println("정상 수정");
				} else {
					System.out.println("수정 중 오류");
				}
				break;
				
			case 4 : // 도서 삭제
				System.out.print("삭제할 도서 번호를 입력하시오 >> ");
				bno = scn.nextInt();scn.nextLine();
				
				if(dao.delete(bno)) {
					System.out.println("정상 삭제");
				} else {
					System.out.println("삭제 중 오류");
				}
				break;
				
			case 5 : // findById
				System.out.print("검색할 도서 번호를 입력하시오 >> ");
				bno = scn.nextInt();scn.nextLine();
				
				if(dao.findById(bno)) {
					System.out.println("정상 검색");
				} else {
					System.out.println("검색 중 오류");
				}
				break;
			case 9 : // 종료
				run = false;
			}
		} // end while
		
		scn.close();
		System.out.println("end of program");
	}// end main

}// end class