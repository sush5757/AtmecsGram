/*
 * package com.atmecsgram.user.controller;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity; import
 * org.springframework.web.bind.annotation.GetMapping; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.PostMapping; import
 * org.springframework.web.bind.annotation.PutMapping; import
 * org.springframework.web.bind.annotation.RequestBody; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController;
 * 
 * import com.atmecsgram.user.dto.LoginDto; import
 * com.atmecsgram.user.dto.UserDto; import com.atmecsgram.user.model.User;
 * import com.atmecsgram.user.service.UserService;
 * 
 * @RestController
 * 
 * @RequestMapping("/user") public class UserController {
 * 
 * @Autowired UserService userService;
 * 
 * @PostMapping("/login") public ResponseEntity<User> login(@RequestBody
 * LoginDto loginRequest) { User user =
 * userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
 * if (user != null) { return new ResponseEntity<>(user, HttpStatus.OK); } else
 * { return new ResponseEntity<>(HttpStatus.UNAUTHORIZED); } }
 * 
 * @PostMapping("/signup") public ResponseEntity<User> createUser(@RequestBody
 * UserDto userdto) { User createdUser = userService.createUser(userdto); return
 * ResponseEntity.ok(createdUser);
 * 
 * }
 * 
 * @GetMapping public ResponseEntity<List<User>> getAllUser() { List<User>
 * allusers = userService.getAllUsers(); return ResponseEntity.ok(allusers); }
 * 
 * @GetMapping("/{id}") public ResponseEntity<User> getUserById(@PathVariable
 * Long id) { return
 * userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.
 * notFound().build());
 * 
 * }
 * 
 * @PutMapping("/{id}") public ResponseEntity<User> updateUser(@PathVariable
 * Long id, @RequestBody UserDto userDto) { User updateUser =
 * userService.updateUser(id, userDto);
 * 
 * return ResponseEntity.ok(updateUser); }
 * 
 * }
 */

package com.atmecsgram.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atmecsgram.user.dto.LoginDto;
import com.atmecsgram.user.dto.UserDto;
import com.atmecsgram.user.model.User;
import com.atmecsgram.user.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/user")
@Tag(name = "User Controller", description = "Endpoints for user login, signup, retrieval, and update operations")
public class UserController {

    @Autowired
    UserService userService;

    @Operation(summary = "Log in a user")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User logged in successfully", 
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginDto loginRequest) {
        User user = userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
        if (user != null) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @Operation(summary = "Sign up a new user")
    @ApiResponse(responseCode = "200", description = "User created successfully",
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @PostMapping("/signup")
    public ResponseEntity<User> createUser(@RequestBody UserDto userdto) {
        User createdUser = userService.createUser(userdto);
        return ResponseEntity.ok(createdUser);
    }

    @Operation(summary = "Get all users")
    @ApiResponse(responseCode = "200", description = "List of all users", 
                 content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class)))
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allusers = userService.getAllUsers();
        return ResponseEntity.ok(allusers);
    }

    @Operation(summary = "Get user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User found", 
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Update a user by ID")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "User updated successfully",
                     content = @Content(mediaType = "application/json", schema = @Schema(implementation = User.class))),
        @ApiResponse(responseCode = "404", description = "User not found", content = @Content)
    })
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        User updateUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updateUser);
    }
}
