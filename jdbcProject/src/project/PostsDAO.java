package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PostsDAO {
	// 게시글 등록, 게시글 목록, 게시글 검색, 게시글 상세 조회, 게시글 제목 수정, 게시글 삭제, 게시판 종료
	// 게시글 등록
	public int createPost(Posts post) {
		Connection conn = DBUtil.getConnect();
		String sql = "INSERT INTO posts (contentId, userId, contentTitle,"
				+ " content, createTime, views) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, post.getContentId());
			pstmt.setString(2, post.getUserId());
			pstmt.setString(3, post.getContentTitle());
			pstmt.setString(4, post.getContent());
			pstmt.setString(5, post.getCreateTime());
			pstmt.setInt(6, post.getViews());

			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	// 게시글 목록
	public ArrayList<Posts> findList() {
		Connection conn = DBUtil.getConnect();
		ArrayList<Posts> postList = new ArrayList<Posts>();
		String sql = "SELECT contentId, userId, contentTitle, createdAt, views FROM posts";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				Posts post = new Posts();
				post.setContentId(rs.getInt("contentId"));
				post.setUserId(rs.getString("userId"));
				post.setContentTitle(rs.getString("contentTitle"));
				post.setCreateTime(rs.getString("createTime"));
				post.setViews(rs.getInt("views"));

				postList.add(post);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return postList;
	}
	// 조회수
	public int getPostCount() {
	    Connection conn = DBUtil.getConnect();
	    String sql = "SELECT COUNT(*) FROM posts";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        if (rs.next()) {
	            return rs.getInt(1);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	

}// end class
