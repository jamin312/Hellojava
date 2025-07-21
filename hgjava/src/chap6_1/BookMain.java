package chap6_1;

import java.util.Scanner;

public class BookMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BookData bookls = new BookData();
		Book[] books = null;
		boolean run = true;
		int booksNum = 0;

		while (run) {
			System.out.println("-------------------------------------------------------");
			System.out.print("1.도서수 입력\s");
			System.out.print("2.도서정보 등록\s");
			System.out.print("3.도서정보 전체조회\s");
			System.out.print("4.도서정보 분석\s");
			System.out.print("5. 종료\n");
			System.out.println("-------------------------------------------------------");
			System.out.print("선택 > ");
			int selectNum = Integer.parseInt(sc.nextLine());

			switch (selectNum) {
			case 1:
				System.out.print("도서 수 > ");
				booksNum = Integer.parseInt(sc.nextLine());
				break;

			case 2:
				books = bookls.bkData(booksNum);
				break;

			case 3:
				for(int i = 0; i < booksNum; i++) {
					System.out.printf("도서 번호 : %d 가격 : %d\n",
							books[i].getBookNum(), books[i].getPrice());					
				}
				break;

			case 4:
				int max = books[0].getPrice();
				int min = books[0].getPrice();
				double avg = 0.0;
				for(int i = 0; i < booksNum; i++) {
					if(books[i].getPrice() > max) {
						max = books[i].getPrice();
					}
					if(books[i].getPrice() < min) {
						min = books[i].getPrice();
					}
				}
				for(int i = 0; i < booksNum; i++) {
					avg += books[i].getPrice();
				}
					avg /= booksNum;
				System.out.println("최고 가격 : " + max + "원");
				System.out.println("최저 가격 : " + min + "원");
				System.out.printf("평균 가격 : %.1f원\n", avg);
				break;

			case 5:
				System.out.print("프로그램 종료");
				run = false;
				break;
				
			default :
				System.out.println("다시 선택하시오");
				break;

			}// end switch

		} // end while
		
		sc.close();
	}// end main

}// end class
