package chap05;

public class Arr204 {

	public static void main(String[] args) {
		// 배열 생성, 배열 데이터 활용
		// p204 예제

		int sum2 = add(new int[] { 83, 90, 87 });
		System.out.println("총합 : " + sum2);
		System.out.println();

		// int형 배열의 크기 5 선언
		// 배열에 50~ 100사이의 수 5개 입력
		// 배열의 합 계산
		int[] ranNums = new int[5];
		for (int i = 0; i < ranNums.length; i++) {
			ranNums[i] = (int) (Math.random() * 51) + 50;
			System.out.print(ranNums[i] + "\s");
		}
		System.out.println();
		System.out.println("난수 5개의 합은 : " + add(ranNums));

	}// end main

	public static int add(int[] scores) {
		int sum = 0;
		for (int i = 0; i < scores.length; i++) {
			sum += scores[i];
		}
		return sum;
	}// end add

}// end class
