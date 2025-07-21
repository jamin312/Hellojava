package chap06;

public class SungjukMain {
//이름 바꿀 때 클래스 파일 우클릭 refactor -> rename;
	public static void main(String[] args) {
		// 객체 생성 => 배열 데이터 받아옴
		// 왼쪽 클래스 오른 생성자
		StudentDao stdao = new StudentDao();
		Student[] students = stdao.stData(); // 실행
		
		//객체 사용 
		for(int i = 0; i < students.length; i++) {
			System.out.printf("이름 : %s\s|국어: %3d\s|영어 : %3d\s|수학 : %3d\s|총합 : %3d\s|평균 : %5.1f\s|등급 :%s\n",
					students[i].name,students[i].kor, students[i].eng,students[i].math,
					students[i].total(),students[i].avg(),students[i].grade());			
		}
		
	}//end main

}//end class
