package d5;

import java.util.Scanner;

public class App {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("IMAGE 1");
		Image img1 = new Image(setTitle());
		System.out.println("-------------------------\n" + "IMAGE 2");
		Image img2 = new Image(setTitle());
		System.out.println("-------------------------\n" + "AUDIO 1");
		Audio aud1 = new Audio(setTitle(), setDuration());
		System.out.println("-------------------------\n" + "AUDIO 2");
		Audio aud2 = new Audio(setTitle(), setDuration());
		System.out.println("-------------------------\n" + "VIDEO 1");
		Video vid1 = new Video(setTitle(), setDuration());

		Multimedia[] multimediaArr = { img1, img2, aud1, aud2, vid1 };

		menu(multimediaArr);

		System.out.println("============\nEnd of task.\n============");
	}

	public static String setTitle() {
		System.out.println("Insert title:");
		String title = scn.nextLine();
		return title;
	}

	public static int setDuration() {
		int duration = 0;
		boolean badValue = true;
		System.out.println("Insert duration:");

		do {
			try {
				duration = Integer.parseInt(scn.nextLine());
				if (duration < 1) {
					System.out.println("Error. Duration must be a value of 1 or more:");
				} else {
					badValue = false;
				}
			} catch (Exception e) {
				System.out.println("Error. Duration must be a value of 1 or more:");
			}
		} while (badValue);

		return duration;
	}

	public static void menu(Multimedia[] mmArr) {
		System.out.println("Execute a multimedia file (1 to 5). Or input 0 to end this task:");
		int mmNum = 0;
		boolean repeat = true;

		do {
			try {
				mmNum = Integer.parseInt(scn.nextLine());
				if (mmNum == 0) {
					repeat = false;
				} else if (mmNum < 1 || mmNum > 5) {
					System.out.println("Error. Insert a valid number:");
				} else {
					mmArr[mmNum - 1].execute();
				}
			} catch (Exception e) {
				System.out.println("Error. Insert a valid number:");
			}
		} while (repeat);
	}

}
