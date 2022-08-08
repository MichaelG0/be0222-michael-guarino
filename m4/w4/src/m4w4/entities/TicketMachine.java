package m4w4.entities;

import javax.persistence.Entity;

@Entity
public class TicketMachine extends AuthorizedDealer {
	private boolean active;

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

}
