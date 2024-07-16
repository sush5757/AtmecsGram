package com.amecsgram.follow.model;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"followerId", "followingId"}))
public class Follow {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "followerId", nullable = false)
    private Long followerId; 

    @JoinColumn(name = "followingId", nullable = false)
    private Long followingId; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    // Constructors
    public Follow() {
    }

    public Follow(Long id, Long followerId, Long followingId, Date created_at) {
        this.id = id;
        this.followerId = followerId;
        this.followingId = followingId;
        this.created_at = created_at;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFollowerId() {
        return followerId;
    }

    public void setFollowerId(Long followerId) {
        this.followerId = followerId;
    }

  
    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Follow [id=" + id + ", followerId=" + followerId + ", followingId=" + followingId + ", created_at=" + created_at + "]";
    }

    public Long getFollowingId() {
		return followingId;
	}

	public void setFollowingId(Long followingId) {
		this.followingId = followingId;
	}

	@PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }
	    
}
