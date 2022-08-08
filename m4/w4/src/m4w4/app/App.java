package m4w4.app;

import java.time.LocalDate;

import m4w4.entities.Card;
import m4w4.entities.dao.CardDAO;

public class App {

	public static void main(String[] args) {
		populate();

	}
	
	public static void populate() {
		Card crd = new Card();
		LocalDate d = LocalDate.of(2022, 1, 10);
		crd.setIssueDate(d);
		crd.setExpirationDate(d);
		
		CardDAO crdDao = new CardDAO();
		crdDao.save(crd);
	}

}
