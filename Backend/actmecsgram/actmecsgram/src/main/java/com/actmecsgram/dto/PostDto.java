package com.actmecsgram.dto;


import java.util.Date;

public class PostDto {
    private Long postId;
    private Long userId;
    private String caption;
    private String imageUrl;
    private String videoUrl;
    private Date createdAt;
    private Date updatedAt;



    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

	@Override
	public String toString() {
		return "PostDto [postId=" + postId + ", userId=" + userId + ", caption=" + caption + ", imageUrl=" + imageUrl
				+ ", videoUrl=" + videoUrl + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + "]";
	}
    
    
    
}
