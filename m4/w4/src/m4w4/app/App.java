package m4w4.app;

import java.time.LocalDate;

import m4w4.entities.AuthorizedDealer;
import m4w4.entities.Card;
import m4w4.entities.TicketMachine;
import m4w4.entities.dao.AuthorizedDealerDAO;
import m4w4.entities.dao.CardDAO;
import m4w4.entities.dao.TicketMachineDAO;

public class App {

	public static void main(String[] args) {
		populate();

	}

	public static void populate() {
		Card crd = new Card();
		LocalDate d = LocalDate.of(2022, 1, 10);
		crd.setCardNumber(394530038999l);
		crd.setIssueDate(d);
		crd.setExpirationDate(d);
		
		Card crd2 = new Card();
		LocalDate d2 = LocalDate.of(2021, 6, 15);
		crd2.setCardNumber(852655284600l);
		crd2.setIssueDate(d2);
		crd2.setExpirationDate(d2);

		CardDAO crdDao = new CardDAO();
		crdDao.save(crd);
		crdDao.save(crd2);

		AuthorizedDealer aut = new AuthorizedDealer();
		AuthorizedDealer aut2 = new AuthorizedDealer();
		AuthorizedDealerDAO autDao = new AuthorizedDealerDAO();
		autDao.save(aut);
		autDao.save(aut2);

		TicketMachine mac = new TicketMachine();
		TicketMachine mac2 = new TicketMachine();
		TicketMachineDAO macDao = new TicketMachineDAO();
		macDao.save(mac);
		macDao.save(mac2);
	}

}
