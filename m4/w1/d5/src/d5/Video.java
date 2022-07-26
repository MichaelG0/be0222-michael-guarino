package d5;

public class Video extends Playable implements IVideo {
	private int brightness = 5;

	public Video(String title, int duration) {
		super(title, duration);
	}
	
	public void execute() {
		for (int i = 1; i <= this.duration; i++) {
			String vol = new String(new char[this.volume]).replace("\0", "!");
			String brt = new String(new char[this.brightness]).replace("\0", "*");
			System.out.println(this.title + " " + vol + " " + brt);
		}
	}

	@Override
	public void brightnessUp() {
		if (this.brightness >= 1 && this.brightness <= 10) this.brightness++;
	}

	@Override
	public void brightnessDown() {
		if (this.brightness >= 1 && this.brightness <= 10) this.brightness--;
	}

}
