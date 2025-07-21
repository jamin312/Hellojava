package chap04;

public class Practice {

	public static void main(String[] args) {
		// 연습장
		
		for (int i = 1; i <= 4; i++) {
		    for (int j = 1; j <= 4 - i; j++) {
		        System.out.print(" ");
		    }
		    for (int k = 1; k <= 2 * i - 1; k++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}
		
		for(int x = 3; x >= 1; x--) {
			for(int y = 1; y <= 4 - x; y++) {
				System.out.print(" ");
			}
			for(int z = 1; z <= 2 * x -1; z++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}// end main

}// end class
