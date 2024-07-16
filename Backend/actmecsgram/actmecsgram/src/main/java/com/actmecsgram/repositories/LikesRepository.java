package com.actmecsgram.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.actmecsgram.models.LikeClass;

@Repository
public interface LikesRepository extends JpaRepository<LikeClass, Long> {
//    List<LikeClass> findByPost_PostId(Integer postId);
//    List<LikeClass> findByUserId(Long userId);
}