package d5;

public abstract class Playable extends Multimedia {
	protected int duration;
	protected int volume = 5;

	public Playable(String title, int duration) {
		super(title);
		this.duration = duration;
	}
	
	public void volumeUp() {
		if (this.volume >= 1 && this.volume <= 10) this.volume++;
	}

	public void volumeDown() {
		if (this.volume >= 1 && this.volume <= 10) this.volume--;
	}
	
}
