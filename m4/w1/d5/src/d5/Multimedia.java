package d5;

public abstract class Multimedia {
	protected String title;

	public Multimedia(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public abstract void execute();

}
