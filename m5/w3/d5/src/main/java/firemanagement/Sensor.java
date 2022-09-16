package firemanagement;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Sensor extends Subject {
	private static int idTracker = 0;
	private int id;
	private double longitude;
	private double latitude;
	private int smokeLevel = 0;

	public Sensor(double longitude, double latitude) {
		this.id = ++idTracker;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public void setSmokeLevel(int smokeLevel) {
		this.smokeLevel = smokeLevel;
		if (this.smokeLevel > 5)
			notifyObservers();
	}

	@Override
	public String toString() {
		return "http://host/alarm?=idsonda=["+id+"]&lon=["+longitude+"]&lat=["+latitude+"]&smokelevel=["+smokeLevel+"]";
	}

}
