package com.amecsgram.follow.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amecsgram.follow.model.Follow;
import com.amecsgram.follow.repository.FollowRepository;

@Service
public class FollowService {
	@Autowired
	private FollowRepository followRepository;

	public void followUser(Long followerId, Long followingId) {
		Optional<Follow> existingFollow = followRepository.findByFollowerIdAndFollowingId(followerId, followingId);
		if (existingFollow.isPresent()) {
			throw new RuntimeException("Already following this user");
		}
		Follow follow = new Follow();
		follow.setFollowerId(followerId);
		follow.setFollowingId(followingId);
		followRepository.save(follow);
	}

	public List<Long> getFollowingIds(Long userId) {
		List<Follow> followings = followRepository.findByFollowerId(userId);
		return followings.stream().map(Follow::getFollowingId).toList();
	}

	public List<Follow> getFollowers(Long userId) {
		return followRepository.findByFollowerId(userId);
	}

	public List<Follow> getFollowing(Long userId) {
		return followRepository.findByFollowingId(userId);
	}

}
