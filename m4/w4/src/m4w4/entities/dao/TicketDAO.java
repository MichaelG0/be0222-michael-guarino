package m4w4.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w4.entities.Ticket;

public class TicketDAO extends JpaUtil<Ticket> {
	public TicketDAO(Class<Ticket> type) {
		super(type);
	}

	@Override
	public void save(Ticket object) {
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(object);
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}
	
}
