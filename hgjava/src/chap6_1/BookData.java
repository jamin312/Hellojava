package chap6_1;

import java.util.Scanner;

public class BookData {
	Scanner sc = new Scanner(System.in);
	//리턴 타입 Book[]
	Book[] bkData(int n) {
		Book[] books = new Book[n];
		
		for(int i = 0; i<n; i++) {
			System.out.printf("%d 번째 도서 정보 입력", i+1);
			System.out.print("도서번호 > ");
			int book = Integer.parseInt(sc.nextLine());
			System.out.print("도서제목 > ");
			String name = sc.nextLine();
			System.out.print("도서가격 > ");
			int price = Integer.parseInt(sc.nextLine());
			
			books[i] = new Book(book,name,price);
		}
		return books;
	}

}// end class
