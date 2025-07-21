package chap04;

import java.util.Scanner;

public class Bank183 {

	public static void main(String[] args) {
		// p183 7번 은행업무
		// 잔고 변수 생성
		// 실행 제어 변수
		// 업무 1 : 예금, 2 : 출금, 3 : 조회, 4 : 종료
		// 종료가 될 때까지 반복
		boolean run = true;
		int balance = 0;
		Scanner sc = new Scanner(System.in);

		while (run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 >");
			int cellNum = Integer.parseInt(sc.nextLine());
			System.out.println();
			int money;
			switch (cellNum) {
			case 1:
				System.out.print("예금액 >");
				money = Integer.parseInt(sc.nextLine());
				balance += money;
				System.out.println();
				break;
				
			case 2:
				System.out.print("출금액 >");
				money = Integer.parseInt(sc.nextLine());
				if(balance >= money) {
					balance -= money;
					System.out.println();
				} else {
					System.out.println("잔고가 부족합니다.");
					System.out.printf("출금 가능 금액 : %d\n", balance);
				}
				break;
				
			case 3:
				System.out.print("잔고 >");
				System.out.println(balance);
				break;
				
			case 4:
				System.out.println("프로그램 종료");
				run = false;
				break;
				
			default :
				System.out.println("잘못된 접근입니다.");
				System.out.println("다시 입력하세요.");
			}
		}
		
		sc.close();
	}//end main

}//end class
