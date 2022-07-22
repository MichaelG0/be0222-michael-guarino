package d2;

public class Rectangle {
	private int height;
	private int width;
	
	public Rectangle(int h, int w) {
		this.height = h;
		this.width = w;
	}
	
	public void printRectangle() {
		int p = 2 * (this.height + this.width);
		int a = this.height * this.width;
		System.out.println("Perimeter = " + p);
		System.out.println("Area = " + a);
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public int getWidth() {
		return this.width;
	}
}
