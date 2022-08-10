package m4w4.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaUtil<T> {
	protected final Logger log = LoggerFactory.getLogger(getClass());

	protected static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("publicTransport");

	public void save(T object) {
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