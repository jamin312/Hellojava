package chap06;

public class StudentDao {
	//학생 데이터 생성
	//필드
	
	//생성자 : 기본 생성자  => 컴파일할 때 자동 생성
	
	//메소드
	Student[] stData(){
		Student[] students = {
				new Student("홍길동", 100, 100, 100),
				new Student("강길동", 90, 90, 90),
				new Student("이길동", 100, 50, 100),
				new Student("황길동", 100, 40, 100),
				new Student("김길동", 10, 10, 30),
				new Student("이길동", 50, 60, 70),
				new Student("박길동", 70, 90, 90),
				new Student("정길동", 50, 40, 60),
				new Student("성길동", 30, 20, 50),
				new Student("신길동", 70, 80, 90)
		};
		return students;
	}
	
}// end class
