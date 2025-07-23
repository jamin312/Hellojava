package project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PostsDAO {
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

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 게시글 조회
	public ArrayList<Posts> findList() {
		Connection conn = DBUtil.getConnect();
		ArrayList<Posts> list = new ArrayList<>();
		String sql = "SELECT * FROM posts ORDER BY contentId DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				Posts p = new Posts();
				p.setContentId(rs.getInt("contentId"));
				p.setUserId(rs.getString("userId"));
				p.setContentTitle(rs.getString("contentTitle"));
				p.setContent(rs.getString("content"));
				p.setCreateTime(rs.getDate("createTime"));
				p.setViews(rs.getInt("views"));
				p.setLikes(rs.getInt("likes"));
				p.setHates(rs.getInt("hates"));
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Posts findById(int contentId) {
		Connection conn = DBUtil.getConnect();
		String sql = "SELECT * FROM posts WHERE contentId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					Posts p = new Posts();
					p.setContentId(rs.getInt("contentId"));
					p.setUserId(rs.getString("userId"));
					p.setContentTitle(rs.getString("contentTitle"));
					p.setContent(rs.getString("content"));
					p.setCreateTime(rs.getDate("createTime"));
					p.setViews(rs.getInt("views"));
					p.setLikes(rs.getInt("likes"));
					p.setHates(rs.getInt("hates"));
					return p;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 게시글 수정
	public int updatePost(int contentId, String title, String content, String userId) {
		Connection conn = DBUtil.getConnect();
		String sql = "UPDATE posts SET contentTitle = ?, content = ? WHERE contentId = ? AND userId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, contentId);
			pstmt.setString(4, userId);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 게시글 삭제
	public int deletePost(int contentId, String userId) {
	    Connection conn = DBUtil.getConnect();
	    try {
	        PreparedStatement deleteVotes = conn.prepareStatement("DELETE FROM post_votes WHERE contentId = ?");
	        deleteVotes.setInt(1, contentId);
	        deleteVotes.executeUpdate();

	        PreparedStatement deleteComments = conn.prepareStatement("DELETE FROM comments WHERE contentId = ?");
	        deleteComments.setInt(1, contentId);
	        deleteComments.executeUpdate();

	        PreparedStatement deletePost = conn.prepareStatement("DELETE FROM posts WHERE contentId = ? AND userId = ?");
	        deletePost.setInt(1, contentId);
	        deletePost.setString(2, userId);
	        int result = deletePost.executeUpdate();

	        return result;

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return 0;
	}

	// 조회수 증가
	public int increaseViews(int contentId) {
		Connection conn = DBUtil.getConnect();
		String sql = "UPDATE posts SET views = views + 1 WHERE contentId = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, contentId);
			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	// 게시글 검색
	public ArrayList<Posts> searchByTitle(String keyword) {
		Connection conn = DBUtil.getConnect();
		ArrayList<Posts> list = new ArrayList<>();
		String sql = "SELECT * FROM posts WHERE contentTitle LIKE ? ORDER BY contentId DESC";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + keyword + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Posts p = new Posts();
				p.setContentId(rs.getInt("contentId"));
				p.setUserId(rs.getString("userId"));
				p.setContentTitle(rs.getString("contentTitle"));
				p.setContent(rs.getString("content"));
				p.setCreateTime(rs.getDate("createTime"));
				p.setViews(rs.getInt("views"));
				p.setLikes(rs.getInt("likes"));
				p.setHates(rs.getInt("hates"));
				list.add(p);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 추천 / 비추천 선택
	public int votePost(String userId, int contentId, String type) {
		Connection conn = DBUtil.getConnect();
		String checkSql = "SELECT 1 FROM post_votes WHERE userId = ? AND contentId = ?";
		String insertSql = "INSERT INTO post_votes (userId, contentId) VALUES (?, ?)";
		String updateSql;

		if ("LIKE".equalsIgnoreCase(type)) {
			updateSql = "UPDATE posts SET likes = likes + 1 WHERE contentId = ?";
		} else if ("DISLIKE".equalsIgnoreCase(type)) {
			updateSql = "UPDATE posts SET hates = hates + 1 WHERE contentId = ?";
		} else {
			return 0;
		}

			try {
				PreparedStatement checkStmt = conn.prepareStatement(checkSql);
				checkStmt.setString(1, userId);
				checkStmt.setInt(2, contentId);
				ResultSet rs = checkStmt.executeQuery();
				if (rs.next()) {
					return -1;
				}

			try (PreparedStatement updateStmt = conn.prepareStatement(updateSql)) {
				updateStmt.setInt(1, contentId);
				updateStmt.executeUpdate();
			}

			try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
				insertStmt.setString(1, userId);
				insertStmt.setInt(2, contentId);
				insertStmt.executeUpdate();
			}

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
}
