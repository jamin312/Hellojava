package 정재민;

import java.util.Scanner;

public class Report1 {

	public static void main(String[] args) {
		// 4-1과제 1번 문제
		// 윤년 평년 계산기
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하시오 >>");
		int inYear = Integer.parseInt(sc.nextLine());
		
		if((inYear % 4 == 0 && inYear % 100 != 0) || inYear % 400 ==0) {
			System.out.printf("%d는 윤년입니다.\n", inYear);
		} else {
			System.out.printf("%d는 평년입니다.\n", inYear);
		}
		
		sc.close();
		
		
	}//end main

}//end class
