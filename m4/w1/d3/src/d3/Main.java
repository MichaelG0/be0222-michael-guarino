package d3;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 3, 7, 1, 9, 3, 0, 5, 8, 2 };

		System.out.println(evenOddString("ciaao") + "\n-------------------");
		System.out.println(leapYear(2100) + "\n-------------------");
		System.out.println(printNum0to3(1) + "\n-------------------");
		System.out.println(splitString("dfg aegve:qfgaew gWE") + "\n-------------------");
		countdown(4);
		System.out.println("-------------------");
		ascendingOrder(arr);
		System.out.println("-------------------");
	}

	public static boolean evenOddString(String str) {
		return str.length() % 2 == 0;
	}

	public static boolean leapYear(int year) {
		return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
	}

	public static String printNum0to3(int n) {
		String res;
		switch (n) {
		case 0:
			res = "zero";
			break;
		case 1:
			res = "one";
			break;
		case 2:
			res = "two";
			break;
		case 3:
			res = "three";
			break;
		default:
			res = "Value must be between 0 and 3";
		}
		return res;
	}

	public static String splitString(String str) {
		String res = "";
		String lastTwo = res;
		int i = 0;
		while (i < str.length() && !":q".equals(lastTwo)) {
			lastTwo = i >= 1 ? "" + str.charAt(i - 1) + str.charAt(i) : res;
			res = "".equals(res) ? "" + str.charAt(i) : res + ", " + str.charAt(i);
			i++;
		}
		return res;
	}

	public static void countdown(int n) {
		for (int i = n; i >= 0; i--)
			System.out.println(i);
	}

	public static void ascendingOrder(int[] arr) {
		for (int n : arr)
			System.out.println(n);
	}

}
