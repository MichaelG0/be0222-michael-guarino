package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "validationByDate", query = "SELECT t FROM Ticket t WHERE t.validationDate >= :fromDate AND t.validationDate <= :toDate")
@NamedQuery(name = "validationByVehicle", query = "SELECT t FROM Ticket t WHERE t.validationVehicle = :valVeh")
public class Ticket extends TicketSuper {
	private LocalDate validationDate;
	private Vehicle validationVehicle;

	public LocalDate getValidationDate() {
		return validationDate;
	}

	public void setValidationDate(LocalDate validationDate) {
		this.validationDate = validationDate;
	}

	@OneToOne
	public Vehicle getValidationVehicle() {
		return validationVehicle;
	}

	public void setValidationVehicle(Vehicle validationVehicle) {
		this.validationVehicle = validationVehicle;
	}

}
