package com.yedam.app;

import java.sql.Connection;
import java.sql.DriverManager;
// ojdbc11.jar 외부 라이브러리 추가
public class DBUtil {
	//DB 접속 정보 활용 -> 세션(Connection 객체)
	//static 객체 생성하지 않고 바로 가져올 수 있음
	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); //오라클 jdbc 유무 확인
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@localhost:1521:xe","scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	} 
	
}// end class
