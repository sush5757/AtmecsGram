package com.actmecsgram.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.actmecsgram.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
