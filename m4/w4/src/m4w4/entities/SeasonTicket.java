package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class SeasonTicket extends Ticket {
	private Duration duration = Duration.WEEKLY;
	private LocalDate expirationDate = this.issueDate.plusDays(7);
	
	@Override
	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	@Enumerated(EnumType.STRING)
	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(LocalDate issueDate) {
		this.expirationDate = issueDate.plusDays(this.duration.getDuration());
	}

}
