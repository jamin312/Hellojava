package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostContentsDAO {
	// 게시글 수정
	public int updatePost(int contentId, String newTitle, String newContent) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "UPDATE posts SET contentTitle = ?, content = ? WHERE contentId = ?";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, newTitle);
	        pstmt.setString(2, newContent);
	        pstmt.setInt(3, contentId);
	        return pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	// 게시글 삭제
	public int deletePost(int contentId) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "DELETE FROM posts WHERE contentId = ?";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, contentId);
	        return pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	// 추천/비추천 (1회 제한)
	public int votePost(String userId, int contentId, String voteType) {
	    Connection conn = DBUtil.getConnect();
	    String checkSql = "SELECT COUNT(*) FROM post_votes WHERE userId = ? AND contentId = ?";
	    String insertSql = "INSERT INTO post_votes (userId, contentId, voteType) VALUES (?, ?, ?)";

	    try {
	        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
	        checkStmt.setString(1, userId);
	        checkStmt.setInt(2, contentId);
	        ResultSet rs = checkStmt.executeQuery();
	        if (rs.next() && rs.getInt(1) > 0) {
	            return -1; // 이미 추천 또는 비추천함
	        }

	        PreparedStatement insertStmt = conn.prepareStatement(insertSql);
	        insertStmt.setString(1, userId);
	        insertStmt.setInt(2, contentId);
	        insertStmt.setString(3, voteType);
	        return insertStmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
}
