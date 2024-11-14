package com.actmecsgram.services;
import com.actmecsgram.models.Post;
import com.actmecsgram.repositories.CommentRepository;
import com.actmecsgram.repositories.LikesRepository;
import com.actmecsgram.repositories.PostRepository;
import com.actmecsgram.dto.CommentDto;
import com.actmecsgram.dto.PostDto;
import com.actmecsgram.models.Comment;
import com.actmecsgram.models.LikeClass;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private LikesRepository likeRepository;
    
    public PostDto createPost(PostDto postDTO) {
        Post post = new Post();
        post.setUserId(postDTO.getUserId());
        post.setCaption(postDTO.getCaption());
        post.setImageUrl(postDTO.getImageUrl());
        post.setVideoUrl(postDTO.getVideoUrl());

        // Save the post and convert it to a PostDTO
        Post savedPost = postRepository.save(post);
        System.out.println(post);
        return new PostDto(savedPost);
    }
    
    public List<PostDto> getAllPosts() {
        return postRepository.findAll().stream()
                .map(PostDto::new)
                .collect(Collectors.toList());
    }
  
}
