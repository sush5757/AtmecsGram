package com.actmecsgram.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Follow {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "follower_id", nullable = false)
    private Long followerId; 

    @JoinColumn(name = "followee_id", nullable = false)
    private Long followeeId; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    // Constructors
    public Follow() {
    }

    public Follow(Long id, Long followerId, Long followeeId, Date created_at) {
        this.id = id;
        this.followerId = followerId;
        this.followeeId = followeeId;
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

    public Long getFolloweeId() {
        return followeeId;
    }

    public void setFolloweeId(Long followeeId) {
        this.followeeId = followeeId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return "Follow [id=" + id + ", followerId=" + followerId + ", followeeId=" + followeeId + ", created_at=" + created_at + "]";
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = new Date();
    }
	    
}
