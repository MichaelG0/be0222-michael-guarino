package m4w4.entities;

import javax.persistence.Entity;

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

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

}
