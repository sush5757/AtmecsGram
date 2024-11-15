package com.atmecsgram.user.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId ;
	
	
	private String first_name;
	
	private String last_name;
	
	@Column(unique = true)
	private String email;
	
	@Column(unique = true)
	private String username;
	
	private String password;
	
	@Temporal(TemporalType.DATE)
	private Date date_of_birth;
	
	private String profile_pic;
	
	private String bio;
	
	private String gender;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date created_at;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated_at;
	

	public User() {
		
	}
	


	public User(Long id, String first_name, String last_name, String email, String username, String password,
			Date date_of_birth, String profile_pic, String bio, String gender, Date created_at, Date updated_at) {
		super();
		this.userId = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.username = username;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.profile_pic = profile_pic;
		this.bio = bio;
		this.gender = gender;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	@Override
	public String toString() {
		return "User [id=" + userId + ", first_name=" + first_name + ", Last_name=" + last_name + ", email=" + email
				+ ", username=" + username + ", password=" + password + ", date_of_birth=" + date_of_birth
				+ ", profile_pic=" + profile_pic + ", bio=" + bio + ", gender=" + gender + ", created_at=" + created_at
				+ ", updated_at=" + updated_at + "]";
	}
	public Long getId() {
		return userId;
	}

	public void setId(Long id) {
		this.userId = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDate_of_birth() {
		return date_of_birth;
	}

	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}

	public String getProfile_pic() {
		return profile_pic;
	}

	public void setProfile_pic(String profile_pic) {
		this.profile_pic = profile_pic;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getCreated_at() {
		return created_at;
	}


	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}


	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	@PrePersist
	protected void onCreate() {
		created_at = new Date();
		updated_at = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		updated_at = new Date();
	}
	
}
