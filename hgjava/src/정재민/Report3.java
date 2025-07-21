package 정재민;

import java.util.Scanner;

public class Report3 {

	public static void main(String[] args) {
		// 4-1과제 3번 문제
		// 숫자 추측 게임
		Scanner sc = new Scanner(System.in);
		int numCom = (int) (Math.random() * 100) + 1;
		boolean run = true;
		while(run) {
			System.out.print("숫자를 입력하시오>>");
			int numYour = Integer.parseInt(sc.nextLine());
			if(numYour > numCom) {
				System.out.println("down하세요!!");
			} else if(numYour < numCom) {
				System.out.println("up하세요!!");
			} else {
				System.out.println("축하합니다.");
				System.out.printf("컴퓨터의 난수는 %d입니다.\n", numCom);
				run = false;
			}
				
		}
		
		
		sc.close();
	}// end main

}// end class
