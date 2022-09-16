package firemanagement;

public class Main {

	public static void main(String[] args) {
		Sensor sensor = new Sensor(41.9028, 12.4964);
		ControlProcess cp1 = new ControlProcess(sensor);
		ControlProcess cp2 = new ControlProcess(sensor);
		
		sensor.setSmokeLevel(6);
		sensor.setSmokeLevel(3);
		sensor.setSmokeLevel(8);
	}

}
