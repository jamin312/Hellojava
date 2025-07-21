package chap05;

import java.util.Calendar;

public class Exam230 {

	public static void main(String[] args) {
		// p230 요일 
		Calendar today = Calendar.getInstance();
		System.out.println(today);
		
		Week day = null;
		int dayNum = today.get(Calendar.DAY_OF_WEEK);
		
		switch(dayNum) {
		case 1 : day = Week.일요일; break; //Week.일요일 -> 주소를 가르킴
		case 2 : day = Week.월요일; break;
		case 3 : day = Week.화요일; break;
		case 4 : day = Week.수요일; break;
		case 5 : day = Week.목요일; break;
		case 6 : day = Week.금요일; break;
		case 7 : day = Week.토요일; break;
		}
		
		System.out.println("오늘은 " + day + "입니다.");
		
	}//end main

}//end class
