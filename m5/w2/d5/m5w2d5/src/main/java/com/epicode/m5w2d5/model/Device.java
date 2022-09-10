package com.epicode.m5w2d5.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epicode.m5w2d5.auth.users.User;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class Device {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@NonNull
	@Enumerated(EnumType.STRING)
	private DeviceType type;
	@NonNull
	@Enumerated(EnumType.STRING)
	private DeviceAvailability availability;
	@ManyToOne
	private User user;
}
