package m4w4.entities.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import m4w4.entities.Ticket;
import m4w4.entities.TicketSeller;

public class TicketDAO extends JpaUtil<Ticket> {
	public TicketDAO() {
		super(Ticket.class);
	}

	public List<Ticket> getTicketsBySellerDuringPeriod(TicketSeller tktSeller, LocalDate fromDate, LocalDate toDate) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("tktBySeller", Ticket.class);
			query.setParameter("ts", tktSeller);
			query.setParameter("fromDate", fromDate);
			query.setParameter("toDate", toDate);
			return query.getResultList();
		} catch (Exception ex) {
			log.error("Error retrieving tickets by ticket seller");
			return new ArrayList<>();
		} finally {
			em.close();
		}
	}

}
