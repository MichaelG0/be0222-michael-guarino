package m4w3d5.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "loanByCardNum", query = "SELECT ln FROM Loan ln WHERE ln.user.cardNumber = :cardNumber")
@NamedQuery(name = "expiredLoan", query = "SELECT ln FROM Loan ln WHERE ln.returnDeadline < CURRENT_DATE AND ln.returnDate IS NULL")
public class Loan {
	private Long id;

	private User user;
	private Read borrowedItem;
	private LocalDate lendingDate;
	private LocalDate returnDeadline;
	private LocalDate returnDate;

	@ManyToOne(fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	public Read getBorrowedItem() {
		return borrowedItem;
	}

	public LocalDate getLendingDate() {
		return lendingDate;
	}

	public LocalDate getReturnDeadline() {
		return returnDeadline;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setBorrowedItem(Read borrowedItem) {
		this.borrowedItem = borrowedItem;
	}

	public void setLendingDate(LocalDate lendingDate) {
		this.lendingDate = lendingDate;
	}

	public void setReturnDeadline(LocalDate lendingDate) {
		this.returnDeadline = lendingDate.plusDays(30);
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
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
