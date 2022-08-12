package m4w4.entities.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import m4w4.entities.TicketDealerSuper;
import m4w4.entities.TicketSuper;

public class TicketSuperDAO extends JpaUtil<TicketSuper> {
	public TicketSuperDAO() {
		super(TicketSuper.class);
	}

	public List<TicketSuper> getTicketsBySellerDuringPeriod(TicketDealerSuper tktSeller, LocalDate fromDate, LocalDate toDate) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("tktBySeller", TicketSuper.class);
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
