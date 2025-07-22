package project;

import java.sql.Timestamp;

public class Posts {
    private int contentId;       	// 게시글 번호 (PostContents contentId 연결)
    private String userId;          // 작성자 ID (Users 연결)
    private String contentTitle;	// 게시글 제목 (PostContents contentTitle 연결)
    private String content;			// 게시글 내용 (PostContents content 연결)
    private String createTime;    // 작성 시간
    private int views;         		// 조회수
    
    public Posts() {}

	public Posts(int contentId, String userId, String contentTitle, String content, Timestamp createdAt, int views) {
		super();
		this.contentId = contentId;
		this.userId = userId;
		this.contentTitle = contentTitle;
		this.content = content;
		this.createTime = createTime;
		this.views = views;
	}

	public int getContentId() {
		return contentId;
	}

	public void setContentId(int contentId) {
		this.contentId = contentId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContentTitle() {
		return contentTitle;
	}

	public void setContentTitle(String contentTitle) {
		this.contentTitle = contentTitle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}
    
	
    
    
    
    
	
    
}
