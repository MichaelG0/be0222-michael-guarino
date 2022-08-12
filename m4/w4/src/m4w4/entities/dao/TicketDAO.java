package m4w4.entities.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import m4w4.entities.Ticket;
import m4w4.entities.Vehicle;

public class TicketDAO extends JpaUtil<Ticket> {
	public TicketDAO() {
		super(Ticket.class);
	}

	public List<Ticket> getValidatedTicketsByDate(LocalDate fromDate, LocalDate toDate) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("validationByDate", Ticket.class);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			return query.getResultList();
		} catch (Exception ex) {
			log.error("Error retrieving validated tickets by date");
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

	public List<Ticket> getValidatedTicketsByVehicle(Vehicle validationVeh) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("validationByVehicle", Ticket.class);
			query.setParameter("valVeh", validationVeh);
			return query.getResultList();
		} catch (Exception ex) {
			log.error("Error retrieving validated tickets by vehicle");
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
