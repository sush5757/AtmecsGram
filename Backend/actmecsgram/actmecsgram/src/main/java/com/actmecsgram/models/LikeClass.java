package com.actmecsgram.models;


import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
public class LikeClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long like_id;

    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    private Post post;

    @JoinColumn(name = "user_id", nullable = false)
    private Long userId; 

    @Temporal(TemporalType.TIMESTAMP)
    private Date created_at;

    // Constructors
    public LikeClass() {
    }

    public LikeClass(Post post, Long userId) {
        this.post = post;
        this.userId = userId;
    }

  
    public Long getLike_id() {
        return like_id;
    }

    public void setLike_id(Long like_id) {
        this.like_id = like_id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

  
    @Override
    public String toString() {
        return "LikeClass [like_id=" + like_id + ", post=" + post + ", user=" + userId + ", created_at=" + created_at + "]";
    }

  
    @PrePersist
    protected void onCreate() {
        created_at = new Date();
    }
}