package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class SeasonTicket extends Ticket {
	private Duration duration = Duration.WEEKLY;
	private LocalDate expirationDate = this.issueDate.plusDays(7);
	
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
		setExpirationDate(issueDate);
	}

	@Enumerated(EnumType.ORDINAL)
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
		setExpirationDate(this.issueDate);
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	private void setExpirationDate(LocalDate issueDate) {
		this.expirationDate = issueDate.plusDays(this.duration.getDuration());
	}

}
