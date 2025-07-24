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
	
	// 제목을 이용해 게시글 검색
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
	
	// 게시글 번호를 이용해 게시글 상세 검색
		public Posts findById(int contentId) {
			Connection conn = DBUtil.getConnect();
			String sql = "SELECT * FROM posts WHERE contentId = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,contentId);
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
	    String sql1 = "DELETE FROM post_votes WHERE contentId = ?";
	    String sql2 = "DELETE FROM comments WHERE contentId = ?";
	    String sql3 = "DELETE FROM posts WHERE contentId = ? AND userId = ?";
	    try {
	    	//post_votes
	        PreparedStatement pstmtVote = conn.prepareStatement(sql1);
	        pstmtVote.setInt(1, contentId);
	        pstmtVote.executeUpdate();
	        //comments
	        PreparedStatement pstmtComments = conn.prepareStatement(sql2);
	        pstmtComments.setInt(1, contentId);
	        pstmtComments.executeUpdate();
	        //posts
	        PreparedStatement pstmtPosts = conn.prepareStatement(sql3);
	        pstmtPosts.setInt(1, contentId);
	        pstmtPosts.setString(2, userId);
	        int result = pstmtPosts.executeUpdate();

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
	
	
	// 추천 비추천 선택
	public int votePost(String userId, int contentId, String type) {
		Connection conn = DBUtil.getConnect();
		String checkSql = "SELECT 1 FROM post_votes WHERE userId = ? AND contentId = ?";
		String insertSql = "INSERT INTO post_votes (userId, contentId, voteType) VALUES (?, ?, ?)";
		String updateSql;
		
		if (type.equals("LIKE")) {
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
			    insertStmt.setString(3, type); 
			    insertStmt.executeUpdate();
			}

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return 0;
	}
	
	// 추천, 비추천 취소
	public int cancelVote(String userId, int contentId) {
	    Connection conn = DBUtil.getConnect();

	    String selVoteSql = "SELECT voteType FROM post_votes WHERE userId = ? AND contentId = ?";
	    String deleteSql = "DELETE FROM post_votes WHERE userId = ? AND contentId = ?";
	    String updateSql; 

	    try {
	        PreparedStatement selStmt = conn.prepareStatement(selVoteSql);
	        selStmt.setString(1, userId);
	        selStmt.setInt(2, contentId);
	        ResultSet rs = selStmt.executeQuery();

	        if (!rs.next()) {
	            return -1;
	        }

	        String voteType = rs.getString("voteType");

	        if (voteType.equals("LIKE")) {
	            updateSql = "UPDATE posts SET likes = likes -1  WHERE contentId = ?";
	        } else if ("DISLIKE".equalsIgnoreCase(voteType)) {
	            updateSql = "UPDATE posts SET hates = hates - 1 WHERE contentId = ?";
	        } else {
	            return 0; 
	        }

	        PreparedStatement updateStmt = conn.prepareStatement(updateSql);
	        updateStmt.setInt(1, contentId);
	        updateStmt.executeUpdate();

	        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
	        deleteStmt.setString(1, userId);
	        deleteStmt.setInt(2, contentId);
	        deleteStmt.executeUpdate();

	        return 1; 

	    } catch (Exception e) {	    	
	        e.printStackTrace();
	    }

	    return 0; 
	}	
	
}
