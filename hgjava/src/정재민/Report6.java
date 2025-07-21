package 정재민;

import java.util.Scanner;

public class Report6 {

	public static void main(String[] args) {
		// 4-1과제 6번 문제
		// 가위(0) 바위(1) 보(2) 게임
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		while (run) {
			int numCom = (int) (Math.random() * 3);
			System.out.print("가위(0) 바위(1) 보(2) 중에 입력하시오," + " 0,1,2를 제외한 수를 입력하면 게임 오버>>");
			int numYour = Integer.parseInt(sc.nextLine());
			if (numYour >= 3 || numYour < 0) {
				System.out.println("game over");
				run = false;
				break;
			} else if (numYour == numCom) {
				System.out.printf("사람 : %d, 컴퓨터 : %d, 무승부\n", numYour, numCom);
			} else if ((numCom + 1) % 3 == numYour) {
				System.out.printf("사람 : %d, 컴퓨터 : %d, 승리\n", numYour, numCom);
			} else {
				System.out.printf("사람 : %d, 컴퓨터 : %d, 패배\n", numYour, numCom);
			}
		}

		sc.close();

	}// end main

}// end class