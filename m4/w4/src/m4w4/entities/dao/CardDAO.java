package m4w4.entities.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w4.entities.Card;

public class CardDAO extends JpaUtil {
	
	public Card getCardByNum(Long cardNum) {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("elByCardNum", Card.class);
			query.setParameter("cardNumber", cardNum);
			return query.getSingleResult();
		} catch (Exception ex) {
			log.error("Error retrieving object");
			return null;
		} finally {
			em.close();
		}
	}
	
}
