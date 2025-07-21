package 정재민;

public class Report7 {

	public static void main(String[] args) {
		// 4-1과제 7번 문제
		// 3, 6, 9게임
//		for (int i = 1; i <= 50; i++) {
//			if(i % 10 == 1 && i != 1) {
//				System.out.printf("\n");
//			}
//			if ((i / 10 == 3 || i / 10 == 6 || i / 10 == 9) && 
//					   (i % 10 == 3 || i % 10 == 6 || i % 10 == 9)) {
//				System.out.print("♥♥\t");
//			} else if (i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
//				System.out.print("♥\t");
//			} else if (i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
//				System.out.print("♥\t");
//			} else {
//				System.out.print(i + "\t");
//			}
//		}
		
		for (int i = 1; i <= 50; i++) {
			int count = 0;
			if(i / 10 == 3 || i / 10 == 6 || i / 10 == 9) {
				count++;
			}
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) {
				count++;
			}
			switch(count) {
			case 0 :
				System.out.printf("%d\t", i);
				break;
			case 1 :
				System.out.printf("♥\t");
				break;
			case 2 :
				System.out.printf("♥♥\t");
				break;
			}
			if(i % 10 == 0) {
				System.out.printf("\n");
			}
		}
		
	}// end main

}// end class
