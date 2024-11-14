package com.actmecsgram.dto;

import com.actmecsgram.models.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class CommentDto {
    @JsonProperty("commentId")
    private Long commentId;

    @JsonProperty("userId")
    private Long userId;

    @JsonProperty("text")
    private String text;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("postId")
    private Integer postId;

	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	 public CommentDto(Comment comment) {
	        this.commentId = comment.getCommentId();
	        this.userId = comment.getUserId();
	        this.text = comment.getText();
	        this.createdAt = comment.getCreatedAt();
	        this.postId = comment.getPost().getPostId();
	    }

	
    	
    
    
}

