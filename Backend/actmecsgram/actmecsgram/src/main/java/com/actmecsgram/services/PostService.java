package com.actmecsgram.services;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.actmecsgram.dto.PostDto;
import com.actmecsgram.dto.UserDto;
import com.actmecsgram.models.Post;

import com.actmecsgram.repositories.PostRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PostService.class);
	@Autowired
	private RestTemplate restTemplate;
	
	private String USER_SERVICE_URL = "http://USER-SERVICE/user/";
	private String FOLLOW_SERVICE_URL = "http://FOLLOW-SERVICE/follow/";
	
	
	public List<Post> getPostsForFollowing(Long userId) {
		logger.info("Fetching following IDs for user ID: {}", userId);
		ResponseEntity<List<Long>> responseEntity = restTemplate.exchange(
			FOLLOW_SERVICE_URL + userId + "/following",
			HttpMethod.GET, null, new ParameterizedTypeReference<List<Long>>() {}
		);
		List<Long> followingIds = responseEntity.getBody();
		logger.info("Following IDs: {}", followingIds);

		if (followingIds == null || followingIds.isEmpty()) {
			logger.warn("No following IDs found for user ID: {}", userId);
			return List.of(); 
		}
		return postRepository.findByUserIdIn(followingIds);
	}

	public Post createPost(PostDto postDto) {
		UserDto user = restTemplate.getForObject(USER_SERVICE_URL + postDto.getUserId(), UserDto.class);
		if (user == null) {
			throw new RuntimeException("User not found with id: " + postDto.getUserId());
		}

		Post post = new Post();
		post.setUserId(postDto.getUserId());
		post.setCaption(postDto.getCaption());
		post.setImage_url(postDto.getImageUrl());
		post.setVideo_url(postDto.getVideoUrl());
		post.setCreated_at(new Date());
		post.setUpdated_at(new Date());

		return postRepository.save(post);

	}

	public UserDto getUserById(Long userId) {
		String url = USER_SERVICE_URL + userId;
		return restTemplate.getForObject(url, UserDto.class);
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();

	}

	public void deletePost(Integer id) {
		postRepository.deleteById(id);
	}

	public List<Post> getPostByUserId(Long userId) {
		return postRepository.findByUserId(userId);
	}

	public List<Post> getPostsSortedByLikes() {
		List<Post> allPosts = getAllPosts();
		return allPosts.stream().sorted(Comparator.comparingInt(Post::getLikesCount).reversed()).toList();
	}

	public Optional<Post> getPostById(Integer id) {
		return postRepository.findById(id);
	}

	public Post updatePost(Integer id, PostDto postDto) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			post.setCaption(postDto.getCaption());
			post.setImage_url(postDto.getImageUrl());
			post.setVideo_url(postDto.getVideoUrl());
			post.setUpdated_at(new Date());
			return postRepository.save(post);
		} else {
			throw new RuntimeException("Post not found with id: " + id);
		}
	}

	public void likePost(Integer id) {
		Optional<Post> optionalPost = postRepository.findById(id);
		if (optionalPost.isPresent()) {
			Post post = optionalPost.get();
			post.getLikes().size();
			postRepository.save(post);
		} else {
			throw new RuntimeException("Post not found with id: " + id);
		}

	}

}
