package project;

import java.sql.Date;

public class Comments {
	private int commentId; // 댓글 번호
	private String userId; // 댓글 작성자 ID
	private int contentId; // 댓글이 달린 게시글의 번호
	private String commentText; // 댓글 내용
	private Date createTime; // 댓글 작성 시간
	
	public Comments(int commentId, String userId, int contentId, String commentText, Date createTime) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.contentId = contentId;
		this.commentText = commentText;
		this.createTime = createTime;
	}
	
	public Comments() {
		// TODO Auto-generated constructor stub
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date date) {
		this.createTime = date;
	}
	
	
	
	
	
}
