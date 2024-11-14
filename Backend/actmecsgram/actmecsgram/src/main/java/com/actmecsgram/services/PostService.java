package com.actmecsgram.services;


import com.actmecsgram.models.Post;
import com.actmecsgram.dto.PostDto;
import java.util.List;


public interface PostService {
	List<PostDto> getAllPosts();
	PostDto createPost(PostDto postDTO);
    
}
