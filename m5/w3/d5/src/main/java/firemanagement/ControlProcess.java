package firemanagement;

public class ControlProcess implements IObserver {
	private static int idTracker = 0;
	private int id;
	private Subject sensor;
	
	public ControlProcess(Subject sensor) {
		this.id = ++idTracker;
		this.sensor = sensor;
		this.sensor.register(this);
	}
	
	@Override
	public void update(Subject s) {
		this.sensor = s;
		System.out.println("Control process [id=" + this.id + "] says: ALARM from " + this.sensor);
	}

	public int getId() {
		return id;
	}

	public Subject getSensor() {
		return sensor;
	}

}
