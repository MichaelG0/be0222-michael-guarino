package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "elByCardNum", query = "SELECT el FROM Card el WHERE el.cardNumber = :cardNumber")
public class Card {
	private Long cardNumber;
	private LocalDate issueDate;
	private LocalDate expirationDate;

	@Id
	@GeneratedValue
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate issueDate) {
		this.expirationDate = issueDate.plusYears(1);
	}
}
