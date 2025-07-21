package chap05;

import java.util.Scanner;

public class Ex223 {

	public static void main(String[] args) {
		// p223 6번
		// if 대신 switch 활용
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("------------------------------------------------");
			System.out.print("선택 > ");
			int selectNum = Integer.parseInt(sc.nextLine());
			
			switch(selectNum) {
			case 1 :
				System.out.print("학생 수 > ");
				studentNum = Integer.parseInt(sc.nextLine());
				scores = new int[studentNum];
				break;
			
			case 2 :
				label : for(int i = 0; i < studentNum; i++) {
					System.out.printf("scores[%d] > ", i);
					scores[i] = Integer.parseInt(sc.nextLine());
					if(scores[i] > 100) {
						System.out.println("다시 입력하시오"); 
						i--;
						continue label;
					}
				}
				break;
			
			case 3 :
				for(int i =0; i < studentNum; i++) {
					System.out.printf("scores[%d] > %d\n", i, scores[i]);
				}
				break;
			
			case 4 :
				int max = 0;
				double scoAvg = 0.0;
//				for(int j = 0; j < scores.length; j++) {
//					scoAvg += scores[j];
//					if(scores[j] > max) {
//						max = scores[j];
//					}
//				}
				for (int score : scores) {
					scoAvg += score;
					if(score > max) {
						max = score;
					}
				}
				
				scoAvg /= studentNum;
				System.out.printf("최고 점수 : %d\n", max);
				System.out.printf("평균 점수 : %f\n", scoAvg);
				break;
				
			case 5 :
				System.out.println("프로그램 종료");
				run = false;
				break;
			
			default :
				System.out.println("숫자를 다시 입력하시오");
				break;
			}
		}
		
		sc.close();
		
	}//end main

}//end class
