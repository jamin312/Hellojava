package project;

public class Comments {
	private String userId; // 댓글 작성자 ID
	private int contentId; // 댓글이 달린 게시글의 본문 ID
	private String commentText; // 댓글 내용
	
	public Comments(String userId, int contentId, String commentText) {
		this.userId = userId;
		this.contentId = contentId;
		this.commentText = commentText;
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
	
	
}
