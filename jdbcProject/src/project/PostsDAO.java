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
	    String sql = "INSERT INTO posts (userId, contentTitle, content) VALUES (?, ?, ?)";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, post.getUserId());
	        pstmt.setString(2, post.getContentTitle());
	        pstmt.setString(3, post.getContent());

	        return pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return 0;
	}
	// 게시글 목록
	public ArrayList<Posts> findList() {
	    ArrayList<Posts> postList = new ArrayList<>();
	    Connection conn = DBUtil.getConnect();
	    String sql = "SELECT contentId, userId, contentTitle, createTime, views FROM posts ORDER BY contentId DESC";

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
	public void increaseViews(int contentId) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "UPDATE posts SET views = views + 1 WHERE contentId = ?";
	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, contentId);
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	//검색
	public ArrayList<Posts> searchByTitle(String keyword) {
	    Connection conn = DBUtil.getConnect();
	    ArrayList<Posts> resultList = new ArrayList<>();
	    String sql = "SELECT contentId, userId, contentTitle, content, createTime, views FROM posts WHERE contentTitle LIKE ? ORDER BY contentId DESC";

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setString(1, "%" + keyword + "%");  // 키워드 포함하는 조건

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            Posts post = new Posts();
	            post.setContentId(rs.getInt("contentId"));
	            post.setUserId(rs.getString("userId"));
	            post.setContentTitle(rs.getString("contentTitle"));
	            post.setContent(rs.getString("content"));
	            post.setCreateTime(rs.getString("createTime"));
	            post.setViews(rs.getInt("views"));

	            resultList.add(post);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return resultList;
	}
	
	
	
	//상세 조회
	public Posts findById(int contentId) {
	    Connection conn = DBUtil.getConnect();
	    String sql = "SELECT * FROM posts WHERE contentId = ?";
	    Posts post = null;

	    try {
	        PreparedStatement pstmt = conn.prepareStatement(sql);
	        pstmt.setInt(1, contentId);
	        ResultSet rs = pstmt.executeQuery();

	        if (rs.next()) {
	            post = new Posts();
	            post.setContentId(rs.getInt("contentId"));
	            post.setUserId(rs.getString("userId"));
	            post.setContentTitle(rs.getString("contentTitle"));
	            post.setContent(rs.getString("content"));
	            post.setCreateTime(rs.getString("createTime"));
	            post.setViews(rs.getInt("views"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return post;
	}
	
	
}// end class
