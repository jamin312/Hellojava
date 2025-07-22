package project;

public class PostContents {
	//필드
	private int contentId;         // 게시글 번호
    private String userId;          // 작성자 ID(users id)
    private String contentTitle;    // 제목
    private String content;         // 게시글 본문
    private int likes;          // 추천 수
    private int hates;			// 비추 수

    //생성자
    public PostContents(int contentId, String userId, String contentTitle, String content, int likes, int hates) {
		this.contentId = contentId;
		this.userId = userId;
		this.contentTitle = contentTitle;
		this.content = content;
		this.likes = likes;
		this.hates = hates;
	}

    //메소드
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

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getHates() {
		return hates;
	}

	public void setHates(int hates) {
		this.hates = hates;
	}
    
    
}

