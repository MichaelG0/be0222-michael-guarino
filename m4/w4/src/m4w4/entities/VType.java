package m4w4.entities;

public enum VType {
	TRAM(60),
	BUS(40);

	private int capacity;
	
	VType(int i) {
		capacity = i;
	}

	public int getCapacity() {
		return capacity;
	}
}
