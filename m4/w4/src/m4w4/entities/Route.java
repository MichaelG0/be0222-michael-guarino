package m4w4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Route {
	private Long id;
	private String departureArea;
	private String terminal;
	private String expectedTravelTime;

	@Id
	@SequenceGenerator(name = "route_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "route_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartureArea() {
		return departureArea;
	}

	public void setDepartureArea(String departureArea) {
		this.departureArea = departureArea;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getExpectedTravelTime() {
		return expectedTravelTime;
	}

	public void setExpectedTravelTime(String expectedTravelTime) {
		this.expectedTravelTime = expectedTravelTime;
	}

	@Override
	public String toString() {
		return "Route [id=" + id + "]";
	}

}
