package com.actmecsgram.controllers;


import com.actmecsgram.services.PostService;
import com.actmecsgram.dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")

public class PostController {

    @Autowired
    private PostService postService;

    /**
     * Create a new post
     * 
     * @param postDTO - Post data transfer object
     * @return PostDTO - The created post data
     */
    @PostMapping
	/*
	 * @ApiOperation(value = "Create a new post", response = PostDTO.class)
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 201, message = "Successfully created the post"),
	 * 
	 * @ApiResponse(code = 400, message = "Bad Request - Invalid input data") })
	 */
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDTO) {
        PostDto createdPost = postService.createPost(postDTO);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    /**
     * Get all posts
     * 
     * @return List<PostDTO> - List of all posts
     */
    @GetMapping
	/*
	 * @ApiOperation(value = "Get all posts", response = PostDTO.class,
	 * responseContainer = "List")
	 * 
	 * @ApiResponses(value = {
	 * 
	 * @ApiResponse(code = 200, message = "Successfully retrieved posts"),
	 * 
	 * @ApiResponse(code = 500, message = "Internal Server Error") })
	 */
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

	/*
	 * @GetMapping("/{postId}") public ResponseEntity<Post>
	 * getPostById(@PathVariable Integer postId) { return
	 * postService.getPostById(postId) .map(ResponseEntity::ok)
	 * .orElse(ResponseEntity.notFound().build()); }
	 * 
	 * @PostMapping public Post createPost(@RequestBody Post post) { return
	 * postService.createPost(post); }
	 * 
	 * @PutMapping("/{postId}") public ResponseEntity<Post> updatePost(@PathVariable
	 * Integer postId, @RequestBody Post postDetails) { try { return
	 * ResponseEntity.ok(postService.updatePost(postId, postDetails)); } catch
	 * (RuntimeException e) { return ResponseEntity.notFound().build(); } }
	 * 
	 * @DeleteMapping("/{postId}") public ResponseEntity<Void>
	 * deletePost(@PathVariable Integer postId) { postService.deletePost(postId);
	 * return ResponseEntity.noContent().build(); }
	 * 
	 * @PostMapping("/{postId}/comments") public ResponseEntity<Comment>
	 * addComment(@PathVariable Integer postId, @RequestBody Comment comment) { try
	 * { return ResponseEntity.ok(postService.addComment(postId, comment)); } catch
	 * (RuntimeException e) { return ResponseEntity.notFound().build(); } }
	 * 
	 * @PostMapping("/{postId}/likes") public ResponseEntity<LikeClass>
	 * addLike(@PathVariable Integer postId, @RequestParam Long userId) { try {
	 * return ResponseEntity.ok(postService.addLike(postId, userId)); } catch
	 * (RuntimeException e) { return ResponseEntity.notFound().build(); } }
	 * 
	 * @DeleteMapping("/{postId}/likes") public ResponseEntity<Void>
	 * removeLike(@PathVariable Integer postId, @RequestParam Long userId) {
	 * postService.removeLike(postId, userId); return
	 * ResponseEntity.noContent().build(); }
	 */
}
