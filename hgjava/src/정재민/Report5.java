package 정재민;

import java.util.Scanner;

public class Report5 {

	public static void main(String[] args) {
		// 4-1과제 5번 문제
		// 섭씨-화씨 온도 변환 프로그램
		// 섭씨 온도(C) = 5/9 * (F-32)
		// 화씨 온도(F) = 9/5 * C +32 
		// 1.화씨 -> 섭씨 2.섭씨 -> 화씨 3. 종료
		
		Scanner sc = new Scanner(System.in);
		boolean run = true;
		double hot = 0;
		while(run) {
			System.out.println("1. 화씨 => 섭씨");
			System.out.println("2. 섭씨 => 화씨");
			System.out.println("3. 종료");
			System.out.println("---------------------------------------------");
			System.out.print("▶번호 선택 : ");
			int num = Integer.parseInt(sc.nextLine());
			switch(num) {
			case 1 : 
				System.out.print("▶화씨 온도 입력 : ");
				hot = Double.parseDouble(sc.nextLine());
				hot = (double)5 / 9 * (hot - 32);
				System.out.printf("섭씨 온도 = %10.7f\n", hot);
				System.out.println("---------------------------------------------");
				break;
				
			case 2 :
				System.out.print("▶섭씨 온도 입력 : ");
				hot = Double.parseDouble(sc.nextLine());
				hot = (double)9 / 5 * hot + 32;
				System.out.printf("화씨 온도 = %10.7f\n", hot);
				System.out.println("---------------------------------------------");
				break;
				
			case 3 :
				System.out.print("program end");
				run = false;
				break;
			default :
				System.out.println("잘못된 접근입니다.");
				System.out.println("다시 입력해주세요");
				System.out.println("---------------------------------------------");
			}
		}
		
		sc.close();
		
	}// end main

}// end class
