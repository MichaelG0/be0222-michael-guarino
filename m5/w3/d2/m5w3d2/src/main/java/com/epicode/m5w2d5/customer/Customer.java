package com.epicode.m5w2d5.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String name;
	private String surname;
	private String address;
	private String cap;
	private String city;
	private String codiceFiscale;
	private String partitaIva;
}
