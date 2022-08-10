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
	private final Class<T> type;
	
	public JpaUtil(Class<T> type) {
		this.type = type;
	}
	
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
	
	public T getById(long id) {
		var em = emf.createEntityManager();
		try {
			return em.find(type, id);
		} catch (Exception ex) {
			log.error("Error retrieving entity with id = {}", id, ex);
			return null;
		} finally {
			em.close();
		}
	}
	
}