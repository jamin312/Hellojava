package chap04;

public class Gugudan {

	public static void main(String[] args) {
		// 구구단
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println("*****" + dan + "단" + "*****");
			for(int gob = 1; gob <= 9; gob++) {
				System.out.printf("%d * %d = %d\n", dan, gob, dan * gob);
			}
			System.out.println();
		}
		
		//과제4-1 4번
		for(int num1 = 2; num1 <= 9; num1++) {
			System.out.printf("%3d단     ", num1);
		}
		System.out.println();
		for(int num2 = 1; num2 <= 9; num2++) {
			for(int num3 = 2; num3 <= 9; num3++) {
				System.out.printf("%dx%d = %2d ", num3, num2, num3 * num2);
			}
			System.out.println();
		}
		
		//p183 6번
		for(int num1 = 1; num1 <= 4; num1++) {
			for(int num3 = 4-num1; num3 > 0; num3--) {
				System.out.print(" ");
			}
			for(int num2 = 1; num2 <= num1; num2++) {
				System.out.print("*");
			}
			System.out.println();
//			String star += "*";
//			System.out.printf("%-4s\n", star);
		}
		
	}// end main

}// end class
