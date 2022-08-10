package m4w4.app;

import java.time.LocalDate;

import m4w4.entities.AuthorizedDealer;
import m4w4.entities.Card;
import m4w4.entities.Duration;
import m4w4.entities.SeasonTicket;
import m4w4.entities.Ticket;
import m4w4.entities.TicketMachine;
import m4w4.entities.dao.JpaUtil;
import m4w4.entities.dao.TicketDAO;

public class App {

	public static void main(String[] args) {
		populate();

	}

	public static void populate() {
		JpaUtil<Card> crdJpa = new JpaUtil<Card>(Card.class);
		JpaUtil<AuthorizedDealer> autJpa = new JpaUtil<AuthorizedDealer>(AuthorizedDealer.class);
		JpaUtil<TicketMachine> macJpa = new JpaUtil<TicketMachine>(TicketMachine.class);
		TicketDAO tktJpa = new TicketDAO(Ticket.class);
		JpaUtil<SeasonTicket> seaJpa = new JpaUtil<SeasonTicket>(SeasonTicket.class);
		/////////////////////////////////
		AuthorizedDealer aut = new AuthorizedDealer();
		AuthorizedDealer aut2 = new AuthorizedDealer();
		
		autJpa.save(aut);
		autJpa.save(aut2);
		/////////////////////////////////
		TicketMachine mac = new TicketMachine();
		TicketMachine mac2 = new TicketMachine();
		
		macJpa.save(mac);
		macJpa.save(mac2);
		/////////////////////////////////
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
		/////////////////////////////////
		SeasonTicket sea = new SeasonTicket();
		sea.setIssueDate(LocalDate.of(2022, 3, 4));
		sea.setDuration(Duration.WEEKLY);
		sea.setTs(mac);
		SeasonTicket sea2 = new SeasonTicket();
		sea2.setDuration(Duration.MONTHLY);
		sea2.setIssueDate(LocalDate.of(2021, 5, 22));
		sea2.setTs(aut2);
		SeasonTicket sea3 = new SeasonTicket();
		sea3.setTs(mac2);
		
		seaJpa.save(sea);
		seaJpa.save(sea2);
		seaJpa.save(sea3);
		/////////////////////////////////
		Card crd = new Card();
		crd.setCardNumber(394530038999l);
		crd.setIssueDate(LocalDate.of(2022, 1, 10));
		crd.setSeaTkt(sea);
		Card crd2 = new Card();
		crd2.setCardNumber(852655284600l);
		crd2.setIssueDate(LocalDate.of(2021, 6, 15));
		crd2.setSeaTkt(sea2);
		Card crd3 = new Card();
		crd3.setCardNumber(645633337720l);
		crd3.setIssueDate(LocalDate.of(2022, 7, 2));
		
		crdJpa.save(crd);
		crdJpa.save(crd2);
		crdJpa.save(crd3);
		
		tktJpa.getById(3).toString();
	}

}
