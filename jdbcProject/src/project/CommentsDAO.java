package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentsDAO {
	// 댓글 목록 보기
	public ArrayList<Comments> findByPostId(int contentId) {
		Connection conn = DBUtil.getConnect();
		ArrayList<Comments> list = new ArrayList<>();
		String sql = "SELECT commentId, contentId, userId, commentText, createTime"
				+ " FROM comments WHERE contentId = ? ORDER BY createTime";

		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentId);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Comments c = new Comments();
				c.setCommentId(rs.getInt("CommentId"));
				c.setUserId(rs.getString("userId"));
				c.setContentId(rs.getInt("contentId"));
				c.setCommentText(rs.getString("commentText"));
				c.setCreateTime(rs.getDate("createTime"));
				list.add(c);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	// 댓글 등록
	public int insert(Comments comment) {
		Connection conn = DBUtil.getConnect();
		String sql = "INSERT INTO comments (commentId, contentId, userId, commentText, createTime)"
				+ " VALUES (comments_seq.NEXTVAL, ?, ?, ?, SYSDATE)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, comment.getContentId());
			pstmt.setString(2, comment.getUserId());
			pstmt.setString(3, comment.getCommentText());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 댓글 수정
	public int update(int commentId, String newText, String loginId, String loginPw) {
		Connection conn = DBUtil.getConnect();
		String checkSql = "SELECT c.userId FROM comments c JOIN users u ON c.userId = u.id "
				+ "WHERE c.commentId = ? AND u.id = ? AND u.pw = ?";
		String updateSql = "UPDATE comments SET commentText = ? WHERE commentId = ?";

		try {
			PreparedStatement checkStmt = conn.prepareStatement(checkSql);
			checkStmt.setInt(1, commentId);
			checkStmt.setString(2, loginId);
			checkStmt.setString(3, loginPw);
			ResultSet rs = checkStmt.executeQuery();

			if (!rs.next()) {
				return -1;
			}

			try {
				PreparedStatement updateStmt = conn.prepareStatement(updateSql);
				updateStmt.setString(1, newText);
				updateStmt.setInt(2, commentId);
				return updateStmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 댓글 삭제
	public int delete(int commentId, String loginId, String loginPw) {
		Connection conn = DBUtil.getConnect();
		String checkSql = "SELECT c.userId FROM comments c JOIN users u ON c.userId = u.id "
						  + "WHERE c.commentId = ? AND u.id = ? AND u.pw = ?";
		String deleteSql = "DELETE FROM comments WHERE commentId = ?";

		try {
			PreparedStatement checkStmt = conn.prepareStatement(checkSql);
			checkStmt.setInt(1, commentId);
			checkStmt.setString(2, loginId);
			checkStmt.setString(3, loginPw);
			ResultSet rs = checkStmt.executeQuery();

			if (!rs.next()) {
				return -1;
			}

			try {
				PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
				deleteStmt.setInt(1, commentId);
				return deleteStmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	//댓글 개수
	public int countByPostId(int contentId) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "SELECT COUNT(*) FROM comments WHERE contentId = ?";
	    int count = 0;

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, contentId);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            count = rs.getInt(1);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return count;
	}
	
}// end class
