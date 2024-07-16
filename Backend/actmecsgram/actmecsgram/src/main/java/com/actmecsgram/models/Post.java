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
	private Integer post_id;
	
	
	private Long userId; 
	
	private String caption;
	private String image_url;
	private String video_url;
	
	 @Temporal(TemporalType.TIMESTAMP)
	    private Date created_at;

	    @Temporal(TemporalType.TIMESTAMP)
	    private Date updated_at;
	
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Comment> comments;
    
    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<LikeClass> likes;

	public Integer getPostId() {
		return post_id;
	}

	public void setPostId(Integer postId) {
		this.post_id = postId;
	}

	

	public Integer getPost_id() {
		return post_id;
	}

	public void setPost_id(Integer post_id) {
		this.post_id = post_id;
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

	public String getImage_url() {
		return image_url;
	}

	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

	public String getVideo_url() {
		return video_url;
	}

	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
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

	public Post() {
		
	}
	public Post(Integer postId, Long user, String caption, String image_url, String video_url, Date created_at,
			Date updated_at, Set<Comment> comments, Set<LikeClass> likes) {
		super();
		this.post_id = postId;
		this.userId = user;
		this.caption = caption;
		this.image_url = image_url;
		this.video_url = video_url;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.comments = comments;
		this.likes = likes;
	}

	@Override
	public String toString() {
		return "Post [postId=" + post_id + ", user=" + userId + ", caption=" + caption + ", image_url=" + image_url
				+ ", video_url=" + video_url + ", created_at=" + created_at + ", updated_at=" + updated_at
				+ ", comments=" + comments + ", likes=" + likes + "]";
	}
	public int getLikesCount() {
		System.out.println("Printing likes "+ likes);
        return this.likes != null ? this.likes.size() : 0;
    }
    
    
}