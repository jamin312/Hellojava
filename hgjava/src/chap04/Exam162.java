package chap04;

import java.util.Scanner;

public class Exam162 {

	public static void main(String[] args) {
		// 주사위 게임
		// 주사위를 2개 던져서 합이 10을 넘으면 두 수를 더하고 
		// 아니면 두 수를 곱한 결과를 출력하시오.
		int num1 = (int)(Math.random()*6) + 1;
		int num2 = (int)(Math.random()*6) + 1;
		int result;
		if (num1 + num2 > 10) {
			result = num1 + num2;
			System.out.printf("%d + %d = %d\n", num1, num2, result);
		} else {
			result = num1 * num2;
			System.out.printf("%d * %d = %d\n", num1, num2, result);
		}
		
		// 오전시간(9시~12) 일정출력
		// 현재 시간 확인
		// 9시 : 출근합니다
		// 10시 : 회의합니다
		// 11시 : 업무를 봅니다
		// 12시 : 외근을 나갑니다
		Scanner sc = new Scanner(System.in);
		System.out.print("현재 시각을 입력하시오>>");
		int nowHour = Integer.parseInt(sc.nextLine());
		
		switch(nowHour) {
		case 9 :
			System.out.println("9시 출근합니다.");
		case 10 :
			System.out.println("10시 회의합니다.");
		case 11 :
			System.out.println("11시 업무를 봅니다.");
		case 12 :
			System.out.println("12시 외근을 나갑니다.");
			break;
		default :
			System.out.println("시간을 잘못 입력했습니다.");
			break;
		}
		System.out.println("오늘 오전 일정 끝");
		
		//p169 3번
		System.out.println("점수를 입력하시오>>");
		int score = Integer.parseInt(sc.nextLine());
		System.out.print("등급은 ");
		switch (score / 10) {
		case 10 :
		case 9 :
			System.out.print("A");
			break;
		case 8 :
			System.out.print("B");
			break;
		case 7 :
			System.out.print("C");
			break;
		default :
			System.out.print("D");
			break;
		}
		System.out.println("입니다.");
		
		sc.close();
		
		// 주사위 게임
		// 주사위 2개 던져서 합이 10이 되면 탈출
		// 주사위 순서쌍 출력(5,2)
		// 5회 이상이 되면 게임 오버
		System.out.println("주사위 2개의 합이 10이면 성공");
		for(int i = 1; i <= 5; i++) {
			int diceNum1 = (int)(Math.random()*6) + 1;
			int diceNum2 = (int)(Math.random()*6) + 1;
			int resultDice;
			resultDice = diceNum1 + diceNum2;
			System.out.println(diceNum1 + "," + diceNum2);
			if(resultDice == 10) {
				System.out.println("주사위를 " + i + "회 던졌습니다.");
				break;
			}
			if(i == 5) {
				System.out.println("주사위를 5회 던졌습니다.");
			}
		} 
		
		// 반복문
		int i;
		for(i = 1; i <= 5; i++) {
			System.out.println("i = " + i);
		}
		System.out.println("탈출 i = " +(i-1) + "까지");
		
		
	}//end main

}//end class
