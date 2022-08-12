package m4w4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@NamedQuery(name = "trvCount", query = "SELECT tr FROM Travel tr WHERE tr.vehicle = :vehicle AND tr.route = :route")
public class Travel {
	private Long id;
	private Vehicle vehicle;
	private Route route;
	private String travelTime;
	
	@Id
	@SequenceGenerator(name = "travel_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "travel_seq")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	@OneToOne
	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	@OneToOne
	public Route getRoute() {
		return route;
	}
	
	public void setRoute(Route route) {
		this.route = route;
	}

	public String getTravelTime() {
		return travelTime;
	}

	public void setTravelTime(String travelTime) {
		this.travelTime = travelTime;
	}

}
