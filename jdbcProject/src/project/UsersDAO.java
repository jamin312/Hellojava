package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersDAO {
	// 회원정보 로그인, 회원가입, ID찾기, PW변경
	// 회원가입
	public int signUp(Users user) {
		Connection conn = DBUtil.getConnect();
		String sql = "INSERT INTO users (id, pw, phone) VALUES (?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getId());
			pstmt.setString(2, user.getPw());
			pstmt.setString(3, user.getPhone());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 로그인
	public boolean logIn(String id, String pw) {
		Connection conn = DBUtil.getConnect();
		String sql = "SELECT * FROM users WHERE id = ? AND pw = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			ResultSet rs = pstmt.executeQuery();
			return rs.next(); // 로그인 성공 여부

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	// ID 찾기 by 전화번호
	public String findIdByPhone(String phone) {
		Connection conn = DBUtil.getConnect();
		String sql = "SELECT id FROM users WHERE phone = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, phone);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return rs.getString("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// 비밀번호 변경
	public int changePassword(String id, String newPw, String phone) {
		Connection conn = DBUtil.getConnect();
		String sql = "UPDATE users SET pw = ? WHERE id = ? AND phone = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPw);
			pstmt.setString(2, id);
			pstmt.setString(3, phone);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 아이디 중복 확인
	public boolean idCheck(String id) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "SELECT id FROM users WHERE id = ?";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, id);  
	        ResultSet rs = pstmt.executeQuery();
	        
	        return rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	// 전화번호 중복 확인
	public boolean phoneCheck(String phone) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "SELECT phone FROM users WHERE phone = ?";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, phone);  
	        ResultSet rs = pstmt.executeQuery();
	        
	        return rs.next(); 
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
}
