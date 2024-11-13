
package com.actmecsgram.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.actmecsgram.dto.PostDto;
import com.actmecsgram.models.Post;
import com.actmecsgram.services.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/home/post")
@Tag(name = "Post Controller", description = "API endpoints for managing posts")
public class PostController {

    @Autowired
    PostService postService;

    @Operation(summary = "Create a new post")
    @ApiResponse(responseCode = "200", description = "Post created successfully",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)))
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody PostDto postDto) {
        Post post = postService.createPost(postDto);
        return ResponseEntity.ok(post);
    }

    @Operation(summary = "Get all posts")
    @ApiResponse(responseCode = "200", description = "List of all posts",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)))
    @GetMapping
    public ResponseEntity<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @Operation(summary = "Get posts by user ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of posts by user ID",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/{userId}")
    public ResponseEntity<List<Post>> getPostByUserId(@PathVariable Long userId) {
        List<Post> posts = postService.getPostByUserId(userId);
        return ResponseEntity.ok(posts);
    }

    @Operation(summary = "Get posts by user's following")
    @ApiResponse(responseCode = "200", description = "List of posts from users being followed",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)))
    @GetMapping("/{userId}/following")
    public ResponseEntity<List<Post>> getPostByUserFollowing(@PathVariable Long userId) {
        List<Post> posts = postService.getPostsForFollowing(userId);
        return ResponseEntity.ok(posts);
    }

    @Operation(summary = "Get posts sorted by likes")
    @ApiResponse(responseCode = "200", description = "List of posts sorted by the number of likes",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class)))
    @GetMapping("/sorted/likes")
    public ResponseEntity<List<Post>> getPostsSortedByLikes() {
        List<Post> posts = postService.getPostsSortedByLikes();
        return ResponseEntity.ok(posts);
    }

    @Operation(summary = "Update a post by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Post updated successfully",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = Post.class))),
        @ApiResponse(responseCode = "404", description = "Post not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody PostDto postDto) {
        Post updatedPost = postService.updatePost(id, postDto);
        return ResponseEntity.ok(updatedPost);
    }

    @Operation(summary = "Delete a post by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Post deleted successfully"),
        @ApiResponse(responseCode = "404", description = "Post not found", content = @Content)
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Integer id) {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Like a post by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "Post liked successfully"),
        @ApiResponse(responseCode = "404", description = "Post not found", content = @Content)
    })
    @PostMapping("/{id}/like")
    public ResponseEntity<Void> likePost(@PathVariable Integer id) {
        postService.likePost(id);
        return ResponseEntity.noContent().build();
    }
}
