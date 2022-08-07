package m4w3d5.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JpaUtil {
	private static final Logger log = LoggerFactory.getLogger(JpaUtil.class);

	private static final EntityManagerFactory entityManagerFactory;

	static {
		try {
			entityManagerFactory = Persistence.createEntityManagerFactory("catalogue");
		} catch (Throwable ex) {
			log.error("Initial EntityManagerFactory creation failed.", ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static EntityManagerFactory getEmf() {
		return entityManagerFactory;
	}

	public static Logger getLog() {
		return log;
	}

}