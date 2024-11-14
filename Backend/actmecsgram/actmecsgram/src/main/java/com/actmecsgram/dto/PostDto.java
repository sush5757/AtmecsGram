package com.actmecsgram.dto;

import com.actmecsgram.models.Post;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class PostDto {
    @JsonProperty("post_id")
    private Integer postId;
    
    @JsonProperty("userId")
    private Long userId;
    
    @JsonProperty("caption")
    private String caption;
    
    @JsonProperty("image_url")
    private String imageUrl;
    
    @JsonProperty("video_url")
    private String videoUrl;
    
    @JsonProperty("created_at")
    private Date createdAt;
    
    @JsonProperty("updated_at")
    private Date updatedAt;
    
    @JsonProperty("comments")
    private List<CommentDto> comments;
    
    @JsonProperty("likes")
    private List<LikeDto> likes;
    
    @JsonProperty("likesCount")
    private int likesCount;

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
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

	public List<CommentDto> getComments() {
		return comments;
	}

	public void setComments(List<CommentDto> comments) {
		this.comments = comments;
	}

	public List<LikeDto> getLikes() {
		return likes;
	}

	public void setLikes(List<LikeDto> likes) {
		this.likes = likes;
	}

	public int getLikesCount() {
		return likesCount;
	}

	public void setLikesCount(int likesCount) {
		this.likesCount = likesCount;
	}
	public PostDto() {
	    // Default constructor
	}

	public PostDto(Post post) {
		this.postId = post.getPostId();
	    this.userId = post.getUserId();
	    this.caption = post.getCaption();
	    this.imageUrl = post.getImageUrl();
	    this.videoUrl = post.getVideoUrl();
	    this.createdAt = post.getCreatedAt();
	    this.updatedAt = post.getUpdatedAt();
	    // Convert Set<Comment> to List<CommentDto>
	    this.comments = post.getComments().stream()
	                         .map(CommentDto::new)  // Assuming CommentDto has a constructor that accepts Comment
	                         .collect(Collectors.toList());
	    // Convert Set<LikeClass> to List<LikeDto>
	    this.likes = post.getLikes().stream()
	                     .map(LikeDto::new)     // Assuming LikeDto has a constructor that accepts LikeClass
	                     .collect(Collectors.toList());
	    this.likesCount = post.getLikesCount();
	}
	

    // Getters and Setters
    
}
