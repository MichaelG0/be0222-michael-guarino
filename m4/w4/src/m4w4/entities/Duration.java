package m4w4.entities;

public enum Duration {
	WEEKLY(7),
	MONTHLY(30);

	Duration(int i) {
		duration = i;
	}

	private int duration;

	public int getDuration() {
		return duration;
	}
}
