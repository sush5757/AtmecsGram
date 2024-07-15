package com.actmecsgram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actmecsgram.models.Post;
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
	  List<Post> findByUserId(Long userId);
	    List<Post> findAllByOrderByLikesDesc();
}
