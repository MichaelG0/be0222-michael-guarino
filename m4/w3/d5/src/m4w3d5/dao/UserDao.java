package m4w3d5.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import m4w3d5.entities.User;

public class UserDao {
	public void save(User obj) {
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

	public void refresh(User obj) {
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

	public User getById(Long id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			return em.find(User.class, id);
		} catch (Exception ex) {
			JpaUtil.getLog().error("Error retrieving object", ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void delete(User obj) {
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

}
