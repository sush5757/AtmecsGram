package com.actmecsgram.dto;
import com.actmecsgram.models.LikeClass;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

public class LikeDto{
    @JsonProperty("like_id")
    private Long likeId;

    @JsonProperty("post")
    private Integer postId;

    @JsonProperty("created_at")
    private Date createdAt;

    @JsonProperty("user")
    private Long userId;

	public Long getLikeId() {
		return likeId;
	}

	public void setLikeId(Long likeId) {
		this.likeId = likeId;
	}

	public Integer getPostId() {
		return postId;
	}

	public void setPostId(Integer postId) {
		this.postId = postId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
	 public LikeDto(LikeClass like) {
	        this.likeId = like.getLikeId();
	        this.postId = like.getPost().getPostId();
	        this.createdAt = like.getCreatedAt();
	        this.userId = like.getUserId();
	    }

    
}
