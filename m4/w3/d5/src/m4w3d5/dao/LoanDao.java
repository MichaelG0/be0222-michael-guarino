package m4w3d5.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w3d5.entities.Loan;

public class LoanDao {
	public void save(Loan obj) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.persist(obj);
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			JpaUtil.getLog().error("Error saving object: " + obj.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void refresh(Loan obj) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			em.refresh(obj);
		} catch (Exception ex) {
			JpaUtil.getLog().error("Error refreshing object: " + obj.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public Loan getById(Long id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			return em.find(Loan.class, id);
		} catch (Exception ex) {
			JpaUtil.getLog().error("Error retrieving object", ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void delete(Loan obj) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(obj);
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			JpaUtil.getLog().error("Error deleting object: " + obj.getClass().getSimpleName(), ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public List<Loan> getLoanByCardNumber(int cardNumber) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("loanByCardNum", Loan.class);
			query.setParameter("cardNumber", cardNumber);
			return query.getResultList();
		} catch (Exception e) {
			JpaUtil.getLog().error("Error");
			return new ArrayList<Loan>();
		} finally {
			em.close();
		}
	}

	public List<Loan> getExpiredLoans() {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("expiredLoan", Loan.class);
			return query.getResultList();
		} catch (Exception e) {
			JpaUtil.getLog().error("Error");
			return new ArrayList<Loan>();
		} finally {
			em.close();
		}
	}
	
}
