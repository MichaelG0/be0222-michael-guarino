package d5;

public class Image extends Multimedia implements IImage {
	private int brightness = 5;

	public Image(String title) {
		super(title);
	}

	public void execute() {
		String brt = new String(new char[this.brightness]).replace("\0", "*");
		System.out.println(this.title + " " + brt);
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
