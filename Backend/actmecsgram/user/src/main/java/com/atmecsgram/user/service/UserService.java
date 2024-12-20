package com.atmecsgram.user.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atmecsgram.user.dto.UserDto;
import com.atmecsgram.user.model.User;
import com.atmecsgram.user.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User createUser(UserDto userDto) {
		User user = new User();

		user.setFirst_name(userDto.getFirst_name());
		user.setLast_name(userDto.getLast_name());
		user.setEmail(userDto.getEmail());
		user.setUsername(userDto.getUsername());
		user.setPassword(userDto.getPassword());
		user.setDate_of_birth(userDto.getDateOfBirth());
		user.setProfile_pic(userDto.getProfilePic());
		user.setBio(userDto.getBio());
		user.setGender(userDto.getGender());
		user.setCreated_at(new Date());
		user.setUpdated_at(new Date());
		return userRepository.save(user);

	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	public User loginUser(String email, String password) {
		User user = userRepository.findByEmail(email);
		if (user != null && password.equals(user.getPassword())) {
			return user;
		}
		return null;
	}

	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

	public Optional<User> getUserById(Long id) {
		return userRepository.findById(id);
	}

	public User findByEmail(String email) {
		return userRepository.findByEmail(email);

	}

	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	public User updateUser(Long id, UserDto userDto) {
		Optional<User> getUser = userRepository.findById(id);

		if (getUser.isPresent()) {
			User user = getUser.get();
			user.setFirst_name(userDto.getFirst_name());
			user.setLast_name(userDto.getLast_name());
			user.setEmail(userDto.getEmail());
			user.setUsername(userDto.getUsername());
			user.setPassword(userDto.getPassword());
			user.setDate_of_birth(userDto.getDateOfBirth());
			user.setProfile_pic(userDto.getProfilePic());
			user.setBio(userDto.getBio());
			user.setGender(userDto.getGender());
			user.setCreated_at(new Date());
			user.setUpdated_at(new Date());
			return userRepository.save(user);

		} else {
			throw new RuntimeException("User not found with id: " + id);
		}
	}
}
