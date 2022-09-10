package com.epicode.m5w1d1.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class User {
	@Id
	@NonNull
	private String username;
	@NonNull
	private String fullName;
	@NonNull
	private String email;
	
}
