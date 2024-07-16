package com.amecsgram.follow.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.amecsgram.follow.model.Follow;
@Repository
public interface FollowRepository extends JpaRepository<Follow,Long>{
	 List<Follow> findByFollowerId(Long followerId);
	    Optional<Follow> findByFollowerIdAndFollowingId(Long followerId, Long followingId);
	  List<Follow> findByFollowingId(Long followingId);
}
