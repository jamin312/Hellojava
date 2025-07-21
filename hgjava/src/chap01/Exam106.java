package chap01;

import java.io.IOException;

public class Exam106 {

	public static void main(String[] args) throws IOException {
		// 문자열 => 숫자
		String str = "10";
		String str2 = "3.14";
		String str3 = "true";
		
		boolean srt3B = Boolean.parseBoolean(str3);
		if(srt3B) {
			System.out.println("타입 변경 성공");
		} else {
			System.out.println("타입 변경 실패");
		}
		
		int strInt = Integer.parseInt(str);
		//int str2Double = Integer.parseInt(str2);
		double str2Double = Double.parseDouble(str2);
		
		System.out.println(strInt + str2Double);
		
		//p109 5번
		char c1 = 'a';
		char c2 = (char)(c1 + 1);
		System.out.println(c2);
		
		//p109 7번
		int x = 5;
		int y = 2;
		double result = (double)x / y;
		System.out.println(result);
		
		//p109 8번
//		double var1 = 3.5;
//		double var2 = 2.7;
//		int resultVar = (int)(var1 + var2);
//		System.out.println(resultVar);
		
		//p110 9번
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int resultVar = (int)(var1 + var2 + var3) + (int)Double.parseDouble(var4);
		System.out.println(resultVar);
		System.out.printf("정수 %d, 실수 %.1f, 실수%8.2f, 문자열 %s, 결과 = %d\n",
				          var1, var2, var3, var4, resultVar);
		
		//표준 입력장치로 키값(유니코드) 입력 받음
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.println(keyCode);
			if(keyCode == 113) {
				break;
			}
		}
		System.out.println("종료");
		
		//예외처리 try catch 
/*		try {
			while(true) {
				int keyCode1;
				System.out.print("문자를 입력하시오>>");
				while(true) {
					keyCode1 = System.in.read();
					System.out.println(keyCode1);
					if(keyCode1 == 10) {
						break;
					}
					if(keyCode1 == 113) {
						System.out.println("종료");
						break;
				} if(keyCode1 == 113) {
					System.out.println("종료");
					break;
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("입력 오류 발생");
		} */
		
		
	}// end main

}// end class
