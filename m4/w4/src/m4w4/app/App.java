package m4w4.app;

import java.time.LocalDate;

import m4w4.entities.AuthorizedDealer;
import m4w4.entities.Card;
import m4w4.entities.SeasonTicket;
import m4w4.entities.Ticket;
import m4w4.entities.TicketMachine;
import m4w4.entities.dao.AuthorizedDealerDAO;
import m4w4.entities.dao.CardDAO;
import m4w4.entities.dao.JpaUtil;
import m4w4.entities.dao.TicketMachineDAO;

public class App {

	public static void main(String[] args) {
		populate();

	}

	public static void populate() {
		JpaUtil<Card> crdJpa = new JpaUtil<Card>();
		JpaUtil<AuthorizedDealer> autJpa = new JpaUtil<AuthorizedDealer>();
		JpaUtil<TicketMachine> macJpa = new JpaUtil<TicketMachine>();
		JpaUtil<Ticket> tktJpa = new JpaUtil<Ticket>();
		JpaUtil<SeasonTicket> seaJpa = new JpaUtil<SeasonTicket>();
		
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
		crdJpa.save(crd);
		crdJpa.save(crd2);

		AuthorizedDealer aut = new AuthorizedDealer();
		AuthorizedDealer aut2 = new AuthorizedDealer();
		autJpa.save(aut);
		autJpa.save(aut2);

		TicketMachine mac = new TicketMachine();
		TicketMachine mac2 = new TicketMachine();
		macJpa.save(mac);
		macJpa.save(mac2);
		
		Ticket tkt = new Ticket();
		tkt.setIssueDate(LocalDate.of(2022, 8, 1));
		tkt.setTs(mac);
		Ticket tkt2 = new Ticket();
		tkt2.setIssueDate(LocalDate.of(2022, 7, 21));
		tkt2.setTs(mac);
		Ticket tkt3 = new Ticket();
		tkt3.setIssueDate(LocalDate.of(2022, 6, 28));
		tkt3.setTs(aut2);
		tktJpa.save(tkt);
		tktJpa.save(tkt2);
		tktJpa.save(tkt3);
		
		SeasonTicket sea = new SeasonTicket();
		sea.setIssueDate(LocalDate.of(2022, 3, 4));
		sea.setTs(mac);
		SeasonTicket sea2 = new SeasonTicket();
		sea2.setIssueDate(LocalDate.of(2021, 5, 22));
		sea2.setTs(aut2);
		seaJpa.save(sea);
		seaJpa.save(sea2);
		
	}

}
