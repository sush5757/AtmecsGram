package com.amecsgram.follow.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amecsgram.follow.model.Follow;
import com.amecsgram.follow.service.FollowService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/follow")
@Tag(name = "Follow Controller", description = "API endpoints for following and unfollowing users")
public class FollowController {

    @Autowired
    FollowService followService;

    @Operation(summary = "Follow a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User followed successfully"),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PostMapping("/{followerId}/follow/{followingId}")
    public ResponseEntity<Void> followUser(@PathVariable Long followerId, @PathVariable Long followingId) {
        followService.followUser(followerId, followingId);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Get following list by user ID")
    @ApiResponse(responseCode = "200", description = "Retrieved list of users being followed",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follow.class)))
    @GetMapping("/{userId}/following")
    public ResponseEntity<List<Follow>> getFollowingIds(@PathVariable Long userId) {
        List<Follow> followingIds = followService.getFollowingIds(userId);
        return ResponseEntity.ok(followingIds);
    }

    @Operation(summary = "Get followers of a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of followers retrieved",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follow.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/followers/{userId}")
    public ResponseEntity<List<Follow>> getFollowers(@PathVariable Long userId) {
        List<Follow> followers = followService.getFollowers(userId);
        return ResponseEntity.ok(followers);
    }

    @Operation(summary = "Get following users of a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "List of users being followed retrieved",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = Follow.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/following/{userId}")
    public ResponseEntity<List<Follow>> getFollowing(@PathVariable Long userId) {
        List<Follow> following = followService.getFollowing(userId);
        return ResponseEntity.ok(following);
    }

    @Operation(summary = "Unfollow a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "204", description = "User unfollowed successfully"),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @DeleteMapping("/{followerId}/unfollow/{followingId}")
    public ResponseEntity<Void> unfollowUser(@PathVariable Long followerId, @PathVariable Long followingId) {
        followService.unfollowUser(followerId, followingId);
        return ResponseEntity.noContent().build();
    }
}
