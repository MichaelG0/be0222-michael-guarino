package m4w4.entities;

public enum Duration {
	WEEKLY(7),
	MONTHLY(30);
	
	private int duration;

	Duration(int i) {
		duration = i;
	}

	public int getDuration() {
		return duration;
	}
}
