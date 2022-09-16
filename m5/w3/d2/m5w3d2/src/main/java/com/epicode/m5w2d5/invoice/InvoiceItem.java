package com.epicode.m5w2d5.invoice;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.epicode.m5w2d5.customer.Customer;

import lombok.Data;

@Entity
@Data
public class InvoiceItem {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String description;
	private String craftsmanship;
	private String materials;
	private int quantity;
	@Enumerated(EnumType.STRING)
	private EUnitOfMeasurement unitOfMeasurement;
	private String cost;
	private String iva;
	@ManyToOne
	private Invoice invoice;
}
