package com.epicode.m5w2d5.invoice;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.epicode.m5w2d5.customer.Customer;

import lombok.Data;

@Entity
@Data
public class Invoice {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@ManyToOne
	private Customer customer;
	private LocalDate date;
	private String number;
	private String description;
	@OneToMany(mappedBy = "invoice")
	private List<InvoiceItem> invoiceItem;
}
