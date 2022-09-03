package com.epicode.m5w1d1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Workstation {
	@Id
	@GeneratedValue
	private Long id;
	private String description;
	private WsType type;
	private int capacity;
	@ManyToOne
	private Building building;
	
}
