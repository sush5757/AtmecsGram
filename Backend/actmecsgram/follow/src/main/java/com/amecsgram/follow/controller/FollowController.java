package com.amecsgram.follow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amecsgram.follow.model.Follow;
import com.amecsgram.follow.service.FollowService;

@RestController
@RequestMapping("/follow")
public class FollowController {

	@Autowired
	FollowService followService;

	@PostMapping("/{followerId}/follow/{followingId}")
	ResponseEntity<Void> followUser(@PathVariable Long followerId, @PathVariable Long followingId) {
		followService.followUser(followerId, followingId);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{userId}/following")
	ResponseEntity<List<Long>> getFollowingIds(@PathVariable Long userId) {
		List<Long> followingIds = followService.getFollowingIds(userId);
		return ResponseEntity.ok(followingIds);

	}

	@GetMapping("/followers/{userId}")
	public ResponseEntity<List<Follow>> getFollowers(@PathVariable Long userId) {
		List<Follow> followers = followService.getFollowers(userId);
		return ResponseEntity.ok(followers);
	}

	@GetMapping("/following/{userId}")
	public ResponseEntity<List<Follow>> getFollowing(@PathVariable Long userId) {
		List<Follow> following = followService.getFollowing(userId);
		return ResponseEntity.ok(following);
	}

}
