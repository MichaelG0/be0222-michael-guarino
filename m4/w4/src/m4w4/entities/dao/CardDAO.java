package m4w4.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w4.entities.Card;

public class CardDAO {
	public void save(Card object) {
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
	
	public Card getCardByNum(Long cardNum) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("elByCardNum", Card.class);
			query.setParameter("cardNumber", cardNum);
			return query.getSingleResult();
		} catch (Exception ex) {
			JpaUtil.getLog().error("Error retrieving object");
			return null;
		} finally {
			em.close();
		}
	}
	
}
