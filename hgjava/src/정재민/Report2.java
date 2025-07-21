package 정재민;

import java.util.Scanner;

public class Report2 {

	public static void main(String[] args) {
		// 4-1과제 2번 문제
		// 동전 교환 프로그램
		Scanner sc = new Scanner(System.in);
		System.out.print("교환할 금액을 입력하시오>>");
		int money = Integer.parseInt(sc.nextLine());
		int firstMoney = money;
		int coin = 500;
		for (int i = 1; i <= 4; i++) {
			int much = money / coin;
			System.out.printf("%d원 갯수 : %d개\n", coin, much);
			money %= coin;
			if (coin == 500) {
				coin = 100;
			} else if (coin == 100) {
				coin = 50;
			} else if (coin == 50) {
				coin = 10;
			}
		}
		firstMoney -= money;
		System.out.printf("교환 금액 : %d원\n", firstMoney);
		System.out.printf("남은 금액 : %d원\n", money);
		
		sc.close();
	}// end main

}// end class
