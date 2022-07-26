package d5;

public class Audio extends Playable implements IAudio {

	public Audio(String title, int duration) {
		super(title, duration);
	}

	public void execute() {
		for (int i = 1; i <= this.duration; i++) {
			String vol = new String(new char[this.volume]).replace("\0", "!");
			System.out.println(this.title + " " + vol);
		}
	}
	
}
