package project;

import java.sql.Date;

public class Posts {
    private int contentId;
    private String userId;
    private String contentTitle;
    private String content;
    private Date createTime;
    private int views;
    private int likes;
    private int hates;

    public Posts() {}

    public Posts(int contentId, String userId, String contentTitle, String content, Date createTime, int views, int likes, int hates) {
        this.contentId = contentId;
        this.userId = userId;
        this.contentTitle = contentTitle;
        this.content = content;
        this.createTime = createTime;
        this.views = views;
        this.likes = likes;
        this.hates = hates;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
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
