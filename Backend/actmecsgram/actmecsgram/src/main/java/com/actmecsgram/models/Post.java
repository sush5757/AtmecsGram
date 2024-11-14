package com.actmecsgram.models;

import java.util.Date;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer postId;

    private Long userId;
    private String caption;
    private String imageUrl;
    private String videoUrl;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LikeClass> likes;

    // Constructors, getters, setters, toString, and utility methods

    public int getLikesCount() {
        return this.likes != null ? this.likes.size() : 0;
    }

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

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public Set<LikeClass> getLikes() {
		return likes;
	}

	public void setLikes(Set<LikeClass> likes) {
		this.likes = likes;
	}

	public Post(Integer postId, Long userId, String caption, String imageUrl, String videoUrl, Date createdAt,
			Date updatedAt, Set<Comment> comments, Set<LikeClass> likes) {
		super();
		this.postId = postId;
		this.userId = userId;
		this.caption = caption;
		this.imageUrl = imageUrl;
		this.videoUrl = videoUrl;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.comments = comments;
		this.likes = likes;
	}

	public Post() {
	
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", userId=" + userId + ", caption=" + caption + ", imageUrl=" + imageUrl
				+ ", videoUrl=" + videoUrl + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", comments="
				+ comments + ", likes=" + likes + "]";
	}
    
    

    // Add other getters, setters, and constructors here as needed.
}