package m4w4.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w4.entities.AuthorizedDealer;

public class AuthorizedDealerDAO {
	public void save(AuthorizedDealer object) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(object);
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			JpaUtil.getLog().error("Error saving object: " + object.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}
}
