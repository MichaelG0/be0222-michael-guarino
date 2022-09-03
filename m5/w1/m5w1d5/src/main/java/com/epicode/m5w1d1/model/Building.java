package com.epicode.m5w1d1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Building {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String address;
	private String city;
}
