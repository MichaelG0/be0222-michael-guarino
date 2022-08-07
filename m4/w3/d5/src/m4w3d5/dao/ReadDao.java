package m4w3d5.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import m4w3d5.entities.Book;
import m4w3d5.entities.Read;

public class ReadDao {
	public void save(Read obj) {
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

	public void refresh(Read obj) {
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

	public Read getById(Long id) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			return em.find(Read.class, id);
		} catch (Exception ex) {
			JpaUtil.getLog().error("Error retrieving object", ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public void delete(Read obj) {
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

	public void deleteByIsbn(String isbn) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			Query query = em.createQuery("DELETE FROM Read el WHERE el.isbn = :isbn");
			query.setParameter("isbn", isbn);
			query.executeUpdate();
			transaction.commit();
		} catch (Exception ex) {
			em.getTransaction().rollback();
			JpaUtil.getLog().error("Error deleting object: " + isbn, ex);
			throw ex;
		} finally {
			em.close();
		}
	}

	public Read getElementByIsbn(String isbn) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("elementByIsbn", Read.class);
			query.setParameter("isbn", isbn);
			return query.getSingleResult();
		} catch (Exception e) {
			JpaUtil.getLog().error("Error");
			return null;
		} finally {
			em.close();
		}
	}

	public List<Read> getReadByPublicationYear(int year) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("elementByPublicationYear", Read.class);
			query.setParameter("publicationYear", year);
			return query.getResultList();
		} catch (Exception e) {
			JpaUtil.getLog().error("Error");
			return new ArrayList<Read>();
		} finally {
			em.close();
		}
	}

	public List<Read> getBookByAuthor(String author) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("bookByAuthor", Read.class);
			query.setParameter("author", author);
			return query.getResultList();
		} catch (Exception e) {
			JpaUtil.getLog().error("Error");
			return new ArrayList<Read>();
		} finally {
			em.close();
		}
	}

	public List<Read> getElementByTitle(String title) {
		EntityManager em = JpaUtil.getEmf().createEntityManager();
		try {
			var query = em.createNamedQuery("elementByTitle", Read.class);
			query.setParameter("title", "%" + title + "%");
			return query.getResultList();
		} catch (Exception e) {
			JpaUtil.getLog().error("Error");
			return new ArrayList<Read>();
		} finally {
			em.close();
		}
	}

}
