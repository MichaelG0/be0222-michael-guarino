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
import m4w4.entities.TicketSeller;
import m4w4.entities.dao.JpaUtil;
import m4w4.entities.dao.TicketDAO;

public class App {
	private final static Logger log = LoggerFactory.getLogger(App.class);
	private final static JpaUtil<Card> crdJpa = new JpaUtil<Card>(Card.class);
	private final static JpaUtil<AuthorizedDealer> autJpa = new JpaUtil<AuthorizedDealer>(AuthorizedDealer.class);
	private final static JpaUtil<TicketMachine> macJpa = new JpaUtil<TicketMachine>(TicketMachine.class);
	private final static TicketDAO tktJpa = new TicketDAO();
	private final static JpaUtil<SeasonTicket> seaJpa = new JpaUtil<SeasonTicket>(SeasonTicket.class);

	public static void main(String[] args) {
		test();

	}

	public static void test() {
		AuthorizedDealer aut = newAuthDealer();
		AuthorizedDealer aut2 = newAuthDealer();

		TicketMachine mac = newTktMachine();
		TicketMachine mac2 = newTktMachine();

		Ticket tkt = newTicket(LocalDate.of(2022, 8, 1), mac);
		Ticket tkt2 = newTicket(LocalDate.of(2022, 7, 21), mac);
		Ticket tkt3 = newTicket(LocalDate.of(2022, 6, 28), aut2);

		Card crd = newCard(394530038999l, LocalDate.of(2022, 1, 10));
		Card crd2 = newCard(852655284600l, LocalDate.of(2021, 6, 15));
		Card crd3 = newCard(645633337720l, LocalDate.of(2022, 7, 2));
		Card crd4 = newCard(659036458844l, LocalDate.of(2022, 8, 9));

		SeasonTicket sea = newSeasonTkt(LocalDate.of(2022, 3, 4), Duration.MONTHLY, mac, 394530038999l);
		SeasonTicket sea2 = newSeasonTkt(LocalDate.of(2021, 5, 22), Duration.MONTHLY, aut2, 852655284600l);
		SeasonTicket sea3 = newSeasonTkt(LocalDate.now(), Duration.WEEKLY, mac2, 659036458844l);

		////// TEST //////
		var from = LocalDate.of(2022, 5, 1);
		var to = LocalDate.now();
		tktJpa.getTicketsBySellerDuringPeriod(mac, from, to).forEach(x -> log.info(x.toString()));

		log.info("{}", isSeasonTicketValid(394530038999l));
		log.info("{}", crdJpa.getById(39453003899l));
	}

	public static AuthorizedDealer newAuthDealer() {
		AuthorizedDealer aut = new AuthorizedDealer();
		autJpa.save(aut);
		return aut;
	}

	public static TicketMachine newTktMachine() {
		TicketMachine mac = new TicketMachine();
		macJpa.save(mac);
		return mac;
	}

	public static Ticket newTicket(LocalDate issueDate, TicketSeller sll) {
		Ticket tkt = new Ticket();
		tkt.setIssueDate(issueDate);
		tkt.setTs(sll);
		tktJpa.save(tkt);
		return tkt;
	}

	public static SeasonTicket newSeasonTkt(LocalDate issueDate, Duration drt, TicketSeller sll, Long cardNum) {
		SeasonTicket sea = null;
		var crd = crdJpa.getById(cardNum);
		if (crd instanceof Card) {
			sea = new SeasonTicket();
			sea.setIssueDate(issueDate);
			sea.setDuration(drt);
			sea.setExpirationDate(issueDate.plusDays(drt.getDuration()));
			sea.setTs(sll);
			crd.setSeaTkt(sea);
			seaJpa.save(sea);
			crdJpa.update(crd);
		} else
			log.error("Invalid card number");
		return sea;
	}

	public static Card newCard(Long cardNum, LocalDate issueDate) {
		Card crd = new Card();
		crd.setCardNumber(cardNum);
		crd.setIssueDate(issueDate);
		crd.setExpirationDate(issueDate.plusYears(1));
		crdJpa.save(crd);
		return crd;
	}

	public static boolean isSeasonTicketValid(Long cardNum) {
		var crd = crdJpa.getById(cardNum);
		return crd != null && !(LocalDate.now().isAfter(crd.getExpirationDate())
				&& LocalDate.now().isAfter(crd.getSeaTkt().getExpirationDate()));
	}

}
