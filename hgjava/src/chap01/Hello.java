package chap01;

public class Hello {
	// 백준 , 프로그래머스
	// void = return 값이 없다는 의미 , string 문자열 ""
	public static void main(String[] args) {
		// 출력문
		System.out.println("hello java!!!");
		int a = 7;
		System.out.println(a);

		// 변수 값 교환
		int x = 10;
		int y = 50;
		int temp = y;
		y = x;
		x = temp;
		System.out.println("x= " + x + " y= " + y);

		// 기본타입
		char font = 'A';
		int intchar = font + 1;
		// char font2 = intchar; 크기가 다르기 때문에 안 됨 char= 2byte int = 4byte
		char font2 = (char) intchar; // 타입 변환
		System.out.print("font는 " + font + " inchar는 " + intchar + "\n");
		System.out.println(font2);

		// 문자열 저장 => String 객체타입 변수 생성
		String str = "홍길동";
		System.out.println(str);

		// 연산 : 정수 => 기본타입 int, 실수 => 기본타입 double
		int su1 = 1;
		int su2 = 3;
		// int result = su1 / su2; -> 0.5를 표현하기 위해 double 타입 필요
		// result에 double 타입을 주어도 이미 계산식이 int타입이기 때문에 0.0이 출력
		double result = (double) su1 / su2;
		System.out.println(result);

		// 문자열 비교
		String str1 = "신용권";
		String str2 = "신용권";
		String str3 = new String("신용권");
		boolean resultStr = str1 == str2; // 주소 비교 => 같은 객체인지 비교
		boolean resultObj = str2 == str3;
		System.out.println(resultStr); // 같은 객체
		System.out.println(resultObj);// 다른 객체
		System.out.println(str1.equals(str3));// 객체 데이터 자체를 비교

		// &=, |=, ^= 연산
		int r1 = 1 & 2; //2진법으로 연산 후 10진수로 변환되어 출력
		int r2 = 1 | 2;
		int r3 = 1 ^ 2;
		System.out.println("and 연산 =" + r1);
		System.out.println("or 연산 =" + r2);
		System.out.println("xor 연산 =" + r3);
		
		// 수 20이 4의 배수이면서 5의 배수인지 확인(if)
		// 결과 = 20은 4와 5의 배수 입니다 출력(printf)
		// 아니면 20은 4와 5의 배수가 아닙니다 출력(printf)
		int num45 = 20;
		if (num45 % 4 == 0 && num45 % 5 == 0) {
			System.out.printf("%d은 4와 5의 배수 입니다\n",num45);
		}  else {
			System.out.printf("%d은 4와 5의 배수가 아닙니다\n",num45);
		}
		
		//홀수 짝수 구별 (삼항연산자)
		// 수는 20을 이용
		String result45 = (num45 % 2 == 0 ? "짝수입니다" : "홀수입니다");
		System.out.println(result45);
		
		
		
	}// end main

}// end class
