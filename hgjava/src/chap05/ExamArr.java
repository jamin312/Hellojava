package chap05;

public class ExamArr {

	public static void main(String[] args) {
		// 배열 과제 1번
		int[] ranNums = new int[10];
		int ranSum = 0;
		int ranMin = 100;
		int ranMax = 0;
		for (int i = 0; i < ranNums.length; i++) {
			ranNums[i] = (int) (Math.random() * 100) + 1;
			System.out.print(ranNums[i] + "\s");
			ranSum += ranNums[i];
			if (ranNums[i] > ranMax) {
				ranMax = ranNums[i];
			}
			if (ranNums[i] < ranMin) {
				ranMin = ranNums[i];
			}
		}
		System.out.println();
		System.out.printf("배열의 합 : %d, 최대값 : %d, 최소값 : %d\n", ranSum, ranMax, ranMin);

		// 배열의 요소 중 4의 배수 출력
		// 4의 배수 갯수 출력
		int cnt = 0;
		for (int j = 0; j < ranNums.length; j++) {
			if (ranNums[j] % 4 == 0) {
				cnt++;
				System.out.print(ranNums[j] + "\s");
			}
		}
		System.out.println();
		System.out.println("4의 배수 개수 : " + cnt);

		// 2차원 배열 선언
		int[][] twoArr = { { 80, 90 }, { 70, 60, 50 } };
		// 2차원 배열 출력
		for (int i = 0; i < twoArr.length; i++) {
			for (int j = 0; j < twoArr[i].length; j++) {
				System.out.printf("| %d ", twoArr[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}

		// 과제 2번
		int[][] arrDou = { { 1, 2, 3 }, { 1, 2 }, { 1 }, { 1, 2, 3 } };

		for (int i = 0; i < arrDou.length; i++) {
			for (int j = 0; j < arrDou[i].length; j++) {
				System.out.print(arrDou[i][j] + "\s");
			}
			System.out.println();
		}

		// int[][] arrDou = new int[4][];
		// arrDou[0] = new int[] {1,2,3};

		// 과제 3번
		int[][] seats = new int[3][10];
		int seatCnt = 0;
		for (int i = 0; i < seats.length; i++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = (int) (Math.random() * 2);
				if (seats[i][j] == 1) {
					seatCnt++;
				}
				System.out.printf("| %d ", seats[i][j]);
			}
			System.out.print("|");
			System.out.println();
		}
		System.out.printf("현재 관객 수는 %d입니다\n", seatCnt);

		// 과제 4번
		double[] stuAvgs = new double[3];
		int[][] studs = new int[3][5];
		for (int i = 0; i < studs.length; i++) {
			for (int j = 0; j < studs[i].length; j++) {
				studs[i][j] = (int) (Math.random() * 51) + 50;
				System.out.print(studs[i][j] + "\s");
				stuAvgs[i] += studs[i][j];
			}
			System.out.println();
		}
		for(int k = 0; k < stuAvgs.length; k++) {
			stuAvgs[k] /= studs[1].length;
			System.out.printf("%d번 학생 평균 = %.2f\n", k+1, stuAvgs[k]);
		}
		
		// 과제 5번
		String[] cards = {
				"Clubs","Diamonds","Hearts","Spades"};
		String[] cardNums = {
				"2","3","4","5","6","7","8","9","10",
				"Jack","Queen","King","Ace"
		};
		for(int i = 1; i <= 5; i++) {
			String ranCard = cards[(int)(Math.random()*cards.length)];
			String ranCard2 = cardNums[(int)(Math.random()*cardNums.length)];
			System.out.printf("%s의 %s\n", ranCard, ranCard2);
		}
		
		// 과제 6번
		System.out.println();
		int[][] fiveNum = new int[3][5];
		
		for(int i = 1; i <= 5; i++) {
			int j = (int)(Math.random()*3);
			int k = (int)(Math.random()*5);
			if(fiveNum[j][k] == 1) {
				i--;
			} else {
				fiveNum[j][k] = 1;
			}
		}
		for(int i = 0; i < fiveNum.length; i++) {
			for(int j = 0; j < fiveNum[i].length; j++) {
				System.out.print(fiveNum[i][j] + "\s");
			}
			System.out.println();
		}
		
	}// end main

}// end class
