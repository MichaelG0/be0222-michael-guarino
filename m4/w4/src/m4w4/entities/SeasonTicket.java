package m4w4.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SeasonTicket extends Ticket {
	private Duration duration;
	private Card card;

	public Duration getDuration() {
		return duration;
	}

	public void setDuration(Duration duration) {
		this.duration = duration;
	}

	@ManyToOne
	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
