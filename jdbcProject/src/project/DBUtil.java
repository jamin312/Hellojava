package project;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public static Connection getConnect() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection
					("jdbc:oracle:thin:@192.168.0.23:1521:xe", "scott", "tiger");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return conn;
	} 
	
}// end class
