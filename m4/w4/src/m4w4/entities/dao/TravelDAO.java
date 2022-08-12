package m4w4.entities.dao;

import m4w4.entities.Route;
import m4w4.entities.Travel;
import m4w4.entities.Vehicle;

public class TravelDAO extends JpaUtil<Travel> {
	public TravelDAO() {
		super(Travel.class);
	}

	public long getNumberOfTravelsOverRoute(Vehicle veh, Route rt) {
		var em = emf.createEntityManager();
		try {
			var query = em.createNamedQuery("trvCount", Travel.class);
			query.setParameter("vehicle", veh);
			query.setParameter("route", rt);
			return (long) query.getResultList().size();
		} catch (Exception ex) {
			return 0;
		} finally {
			em.close();
		}
	}

}
