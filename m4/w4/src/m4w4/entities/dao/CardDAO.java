package m4w4.entities.dao;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w4.entities.Card;
import m4w4.entities.Ticket;

public class CardDAO extends JpaUtil<Card> {
	public CardDAO() {
		super(Card.class);
	}

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

	public boolean isSeasonTicketValid() {
		EntityManager em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("isTktValid", Card.class);
			query.setParameter("today", LocalDate.now());
			log.info("Valid season ticket");
			return true;
		} catch (Exception ex) {
			log.error("Invalid season ticket");
			return false;
		} finally {
			em.close();
		}
	}

}
