package chap06;

public class Student {
	// 객체 생성 클래스
	// 필드 : 객체의 속성(데이터)
		String name;
		int kor;
		int eng;
		int math;
		
	// 생성자 : 객체 생성 시 속성값 초기화
	// this -> 필드에 값 저장
		Student(String name, int kor, int eng, int math){
			this.name = name; // 매개변수 우선 , 충돌방지를 위해 this
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		
	// 메소드 : 객체의 기능
	//총점을 구하는 메소드
		int total() {
			int sum = this.kor + this.eng + this.math;
			return sum;
		}
		
	//평균을 구하는 메소드
		double avg() {
			return this.total() / 3.0;
		}
	
	//등급을 구하는 메소드
		char grade() {
			char gradeChar;
			switch((int)this.avg() / 10) {
			case 10 :
			case 9 : gradeChar = 'A'; break;
			case 8 : gradeChar = 'B'; break;
			case 7 : gradeChar = 'C'; break;
			case 6 : gradeChar = 'D'; break;
			default : gradeChar = 'F';
			}
			return gradeChar;
		}
}// end class
