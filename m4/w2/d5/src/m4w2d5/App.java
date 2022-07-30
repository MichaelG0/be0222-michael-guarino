package m4w2d5;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;

public class App {
	private static List<Read> catalogue = new ArrayList<Read>(Arrays.asList( //
			new Book(9457219834l, "qwerty", 2018, 456, "Joe", "Action"), //
			new Book(2457819682l, "asdfgh", 2021, 757, "John", "Adventure"), //
			new Book(7714164244l, "zxcvbn", 1984, 99, "Joseph", "Drama"), //
			new Book(4567893454l, "poiuy", 2022, 101, "Jonathan", "Comedy"), //
			new Magazine(5915478263l, "lkjhg", 2018, 55, Periodicity.MONTHLY), //
			new Magazine(8264779356l, "mnbvc", 2017, 46, Periodicity.SEMIANNUAL), //
			new Magazine(1675849485l, "uytred", 2021, 37, Periodicity.WEEKLY), //
			new Magazine(3476131669l, "xdfghj", 2019, 82, Periodicity.MONTHLY) //
	));

	private static final File catalogueTxt = new File("./catalogue.txt");

	public static void main(String[] args) throws IOException {
		addRead(6273485967l, "fcvbnkl", 2021, 78, "Joe", "Thriller");
		addRead(3648436646l, "qwrfghg", 2022, 29, Periodicity.WEEKLY);
		removeByIsbn(5915478263l);
		searchByPublicationYear(2021).forEach(System.out::println);
		System.out.println("===============================================\n");
		searchByAuthor("Joe").forEach(System.out::println);
		System.out.println("===============================================\n");
		saveOnDisk();
		loadFromDisk();
	}

	public static void addRead(long isbn, String title, int publicationYear, int numberOfPages, String author,
			String genre) {
		catalogue.add(new Book(isbn, title, publicationYear, numberOfPages, author, genre));
	}

	public static void addRead(long isbn, String title, int publicationYear, int numberOfPages,
			Periodicity periodicity) {
		catalogue.add(new Magazine(isbn, title, publicationYear, numberOfPages, periodicity));
	}

	public static void removeByIsbn(long isbn) {
		Read objToRemove = (Read) catalogue.stream() //
				.filter(r -> r.getIsbn() == isbn) //
				.findAny().orElse(null);
		catalogue.remove(objToRemove);
	}

	public static List<Read> searchByPublicationYear(long year) {
		System.out.println("=============== Reads from " + year + " ===============");
		return catalogue.stream() //
				.filter(r -> r.getPublicationYear() == year) //
				.collect(Collectors.toList());
	}

	public static List<Read> searchByAuthor(String author) {
		System.out.println("================ Reads by " + author + " =================");
		return catalogue.stream() //
				.filter(r -> r instanceof Book) //
				.map(b -> (Book) b) //
				.filter(r -> r.getAuthor().equals(author)) //
				.collect(Collectors.toList());
	}

	public static void saveOnDisk() throws IOException {
		List<String> catToStrArr = new ArrayList<String>();
		String catalogueToTxt = "";
		
		for (Read r : catalogue) {
			catToStrArr.add(r.toString());
		}
		Collections.sort(catToStrArr);
		
		for (String s : catToStrArr) {
			catalogueToTxt += s + "\n";
		}
		FileUtils.writeStringToFile(catalogueTxt, catalogueToTxt, "UTF-8");
	}

	public static void loadFromDisk() throws IOException {
		catalogue.clear();
		String[] catalogueFromTxt = FileUtils.readFileToString(catalogueTxt, "UTF-8").split("\n");

		String[] split;
		for (String r : catalogueFromTxt) {
			split = r.split("_");
			if (r.startsWith("Book"))
				addRead(Long.parseLong(split[1]), split[3], Integer.parseInt(split[5]), Integer.parseInt(split[7]),
						split[9], split[11]);
			else if (r.startsWith("Magazine"))
				addRead(Long.parseLong(split[1]), split[3], Integer.parseInt(split[5]), Integer.parseInt(split[7]),
						Periodicity.valueOf(split[9]));
		}
		System.out.println("=============== Loaded Catalogue ==============");
		catalogue.forEach(System.out::println);
	}

}
