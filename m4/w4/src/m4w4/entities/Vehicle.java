package m4w4.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Vehicle {
	private Long id;
	private VType type;
	private Route route;

	@Id
	@SequenceGenerator(name = "vehicle_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehicle_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Enumerated(EnumType.STRING)
	public VType getVType() {
		return type;
	}

	public void setVType(VType type) {
		this.type = type;
	}

	@OneToOne
	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", type=" + type + "]";
	}
	
}
