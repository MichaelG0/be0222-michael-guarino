package d2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rect1 = new Rectangle(7, 12);
		Rectangle rect2 = new Rectangle(8, 4);
		
		rect1.printRectangle();
		printTwoRectangles(rect1, rect2);
		
	}

	public static void printTwoRectangles(Rectangle r1, Rectangle r2) {
		int p1 = 2 * (r1.getHeight() + r1.getWidth());
		int a1 = r1.getHeight() * r1.getWidth();
		int p2 = 2 * (r1.getHeight() + r1.getWidth());
		int a2 = r1.getHeight() * r1.getWidth();
		int totP = p1 + p2;
		int totA = a1 + a2;
		
		System.out.println("R1 perimeter = " + p1);
		System.out.println("R1 area = " + a1);
		System.out.println("R2 perimeter = " + p2);
		System.out.println("R2 area = " + a2);
		System.out.println("Total perimeter = " + totP);
		System.out.println("Total area = " + totA);
	}
	
}
