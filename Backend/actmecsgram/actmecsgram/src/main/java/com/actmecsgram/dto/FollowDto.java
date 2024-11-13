package com.actmecsgram.dto;

import java.util.Date;

public class FollowDto {

    private Long id;
    private Long followerId;
    private Long followingId;
    private Date createdAt;

    // Constructors
    public FollowDto() {
    }

    public FollowDto(Long id, Long followerId, Long followingId, Date createdAt) {
        this.id = id;
        this.followerId = followerId;
        this.followingId = followingId;
        this.createdAt = createdAt;
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

    public Long getFollowingId() {
        return followingId;
    }

    public void setFollowingId(Long followingId) {
        this.followingId = followingId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "FollowDto [id=" + id + ", followerId=" + followerId + ", followingId=" + followingId + ", createdAt=" + createdAt + "]";
    }
}
