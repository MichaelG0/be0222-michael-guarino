package com.epicode.m5w1d1.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.NonNull;

@Entity
@Data
public class Reservation {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	@NonNull
	private User user;
	@ManyToOne
	@NonNull
	private Workstation ws;
	@NonNull
	private LocalDate date;
	
}
