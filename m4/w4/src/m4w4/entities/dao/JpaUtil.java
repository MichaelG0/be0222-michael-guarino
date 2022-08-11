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

	public void save(T obj) {
		var em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.persist(obj);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error("Error saving object: " + obj.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void update(T obj) {
		var em = emf.createEntityManager();
		try {
			em.getTransaction().begin();
			em.merge(obj);
			em.getTransaction().commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			log.error("Error saving object: " + obj.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public T getById(long id) {
		var em = emf.createEntityManager();
		try {
			var obj = em.find(type, id);
			if (obj == null)
				log.error("Id {} is not valid.", id);
			return obj;
		} finally {
			em.close();
		}
	}

}