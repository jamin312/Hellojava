package chap01;

import java.util.Scanner;

public class Ex149 {

		public static void main(String[] args) {
			// p149 문제
			//1
//			byte b = 5; -연산이므로 int타입으로 변화됨
			int b = 5;
			b = -b;
			int result = 10 / b;
			System.out.println(result);
			
			//2
			//z = 31
			
			//3
			boolean stop = true;
			while (!stop == true) {
				if(stop == true)
					break;
			}
			
			//4
			int pencils = 534;
			int students = 30;
			
			int pencilsPerStudent = (pencils / students);
			System.out.println("인당 연필의 개수는 " + pencilsPerStudent);
			
			int pencilsLeft = (pencils % students);
			System.out.println("남은 연필의 개수는 " + pencilsLeft);
			
			//5
			int var1 = 5;
			int var2 = 2;
//			double var3 = var1 / var2; 연산결과가 int값이 나온 후 더블로 변경해도 2.0이 출력
			double var3 = (double) var1 / var2;
			int var4 = (int)(var3 * var2);
			System.out.println(var4);
			
			//6
			int value = 356;
			System.out.println(value / 100 * 100);
			
			//7
			float var71 = 10f;
//			float var72 = var71 / 100; 
			//결과값은 0.1f입니다. 0.1f는 0.1보다 큰 근삿값을 가지므로 같지 않음
			double var72 = (double)var71 / 100;
			if(var72 == 0.1) {
				System.out.println("10%입니다");
			} else {
				System.out.println("10%가 아닙니다");
			}
			
			//8
			int lengthTop = 5;
			int lengthBottom = 10;
			int height = 7;
			double area = ((lengthTop + lengthBottom) * height * 0.5);
			System.out.println(area);
			
			//9
			Scanner sc = new Scanner(System.in);
			
			System.out.println("첫 번째 수>>");
			double firstNum = Double.parseDouble(sc.nextLine());
			
			System.out.println("두 번째 수>>");
			double secondNum = Double.parseDouble(sc.nextLine());
			
			double finalNum = firstNum / secondNum;
			if(!(secondNum == 0)) {
				System.out.printf("결과 : %f\n", finalNum);
			} else {
				System.out.println("결과 : 무한대");
			}
			
			//10
			int varC1 = 10;
			int varC2 = 3;
			int varC3 = 14;
//			double varC4 = varC1 * varC1 * varC2 + "." + varC3;
			// 위의 결과값은 String이다. 그러므로 double타입으로 변환이 필요
			double varC4 = varC1 * varC1 * Double.parseDouble(varC2 + "." + varC3);
			System.out.println("원의 넓이 :" + varC4);
			
			//11
			System.out.print("아이디 : ");
			String name = sc.nextLine();
			
			System.out.print("패스워드 : ");
			String strPw = sc.nextLine();
			int password = Integer.parseInt(strPw);
			
			if(name.equals("java")) {
				if(password == 12345) {
					System.out.println("로그인 성공");
				} else {
					System.out.println("로그인 실패 : 패스워드가 틀림");
				}
			} else {
				System.out.println("로그인 실패 : 아이디 존재하지 않음");
			}
			
			//12 true, false
			
			//13
			//value += 10; 
			//value -= 10;
			//value *= 10;
			//value /= 10;
			
			//14 가
			
			//4로 나누어 떨어지고 100으로 나누어 떨어지지 않으면 윤년
			//400으로 나누어 떨어지면 윤년
			System.out.println("년도를 입력하시오>>");
			int yearNum = Integer.parseInt(sc.nextLine());
			if ((yearNum % 4 == 0 && yearNum % 100 != 0) || yearNum % 400 == 0) {
				System.out.printf("%d년은 윤년 입니다", yearNum);
			} else {
				System.out.printf("%d년은 평년 입니다", yearNum);
			}
			
			sc.close();
	}

}
