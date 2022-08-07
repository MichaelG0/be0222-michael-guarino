package m4w3d5.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	private Long id;
	
	private String name;
	private String surname;
	private LocalDate dateOfBirth;
	private int cardNumber;
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	public int getCardNumber() {
		return cardNumber;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public void setCardNumber(int cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}
