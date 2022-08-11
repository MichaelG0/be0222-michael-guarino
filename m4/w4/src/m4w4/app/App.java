package m4w4.app;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m4w4.entities.AuthorizedDealer;
import m4w4.entities.Card;
import m4w4.entities.Duration;
import m4w4.entities.SeasonTicket;
import m4w4.entities.Ticket;
import m4w4.entities.TicketMachine;
import m4w4.entities.dao.CardDAO;
import m4w4.entities.dao.JpaUtil;
import m4w4.entities.dao.TicketDAO;

public class App {
	private final static Logger log = LoggerFactory.getLogger(App.class);
	private final static CardDAO crdJpa = new CardDAO();
	private final static JpaUtil<AuthorizedDealer> autJpa = new JpaUtil<AuthorizedDealer>(AuthorizedDealer.class);
	private final static JpaUtil<TicketMachine> macJpa = new JpaUtil<TicketMachine>(TicketMachine.class);
	private final static TicketDAO tktJpa = new TicketDAO();
	private final static JpaUtil<SeasonTicket> seaJpa = new JpaUtil<SeasonTicket>(SeasonTicket.class);

	public static void main(String[] args) {
		populate();

	}

	public static void populate() {
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
		sea.setDuration(Duration.MONTHLY);
		sea.setExpirationDate(LocalDate.of(2022, 3, 4));
		sea.setTs(mac);
		SeasonTicket sea2 = new SeasonTicket();
		sea2.setDuration(Duration.MONTHLY);
		sea2.setIssueDate(LocalDate.of(2021, 5, 22));
		sea2.setExpirationDate(LocalDate.of(2021, 5, 22));
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
		crd.setExpirationDate(LocalDate.of(2022, 1, 10));
		crd.setSeaTkt(sea);
		Card crd2 = new Card();
		crd2.setCardNumber(852655284600l);
		crd2.setIssueDate(LocalDate.of(2021, 6, 15));
		crd2.setExpirationDate(LocalDate.of(2021, 6, 15));
		crd2.setSeaTkt(sea2);
		Card crd3 = new Card();
		crd3.setCardNumber(645633337720l);
		crd3.setIssueDate(LocalDate.of(2022, 7, 2));
		crd3.setExpirationDate(LocalDate.of(2022, 7, 2));

		crdJpa.save(crd);
		crdJpa.save(crd2);
		crdJpa.save(crd3);

		////// TEST//////
		log.info("{}", tktJpa.getById(3).toString());
		var from = LocalDate.of(2022, 5, 1);
		var to = LocalDate.of(2022, 7, 21);
		tktJpa.getTicketsBySellerDuringPeriod(mac, from, to).forEach(x -> log.info(x.toString()));
		
		log.info("{}", crdJpa.getCardByNum(645633337720l).toString());
		log.info("{}", crdJpa.isSeasonTicketValid());
	}
	
	public static void newAuthDealer() {
		AuthorizedDealer aut = new AuthorizedDealer();
		autJpa.save(aut);
	}

}
