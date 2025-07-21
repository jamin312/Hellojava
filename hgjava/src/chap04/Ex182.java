package chap04;

public class Ex182 {

	public static void main(String[] args) {
		// p182 문제2
		// 1~100까지 3의 배수 총합, 3의 배수 갯수
		int sum = 0;
		int count = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 0) {
				sum += i;
				count++;
			}
		}
		System.out.printf("%d는 3의 배수 총합, %d는 3의 배수 개수\n", sum, count);

		// p183 문제3
		// 추가 : 몇 번만에 탈출했는지 출력
		int diceNum1 = 0;
		int diceNum2 = 0;
		int cnt = 0;
		while (true) {
			diceNum1 = (int) (Math.random() * 6) + 1;
			diceNum2 = (int) (Math.random() * 6) + 1;
			cnt++;
			System.out.printf("(%d,%d)", diceNum1, diceNum2);
			if (diceNum1 + diceNum2 == 5) {
				break;
			}
		}
		System.out.println();
		System.out.printf("주사위 던진 횟수 : %d\n", cnt);

		// p184 문제4
		System.out.println("4x + 5y = 60을 만족하는 해를 구하시오, 10이하의 자연수");
		for (int xP = 1; xP <= 10; xP++) {
			for (int yP = 1; yP <= 10; yP++) {
				int resultP = 4 * xP + 5 * yP;
				if (resultP == 60) {
					System.out.printf("x = %d, y = %d\n", xP, yP);
				}
			}
		}
		
		// p183 문제 6번
		for(int i = 1; i <= 4; i++) {
			for(int j = 4; j >= 1; j--) {
				if(j > i) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println(" ");
		}
		

	}// end main

}// end class
