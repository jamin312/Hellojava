package 정재민;

public class Report4 {

	public static void main(String[] args) {
		// 4-1과제 4번 문제
		// 구구단
		for (int i = 2; i <= 9; i++) {
			System.out.printf("%3d단     ", i);
		}
		System.out.println();
		for (int j = 1; j <= 9; j++) {
			for (int k = 2; k <= 9; k++) {
				System.out.printf("%2dx%d=%2d  ", k, j, k * j);
			}
			System.out.println();
		}

	}// end main

}// end class
