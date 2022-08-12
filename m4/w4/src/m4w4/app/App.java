package m4w4.app;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m4w4.entities.AuthorizedDealer;
import m4w4.entities.Card;
import m4w4.entities.Duration;
import m4w4.entities.Route;
import m4w4.entities.SeasonTicket;
import m4w4.entities.Ticket;
import m4w4.entities.TicketMachine;
import m4w4.entities.TicketDealerSuper;
import m4w4.entities.Travel;
import m4w4.entities.VType;
import m4w4.entities.Vehicle;
import m4w4.entities.dao.JpaUtil;
import m4w4.entities.dao.TicketDAO;
import m4w4.entities.dao.TicketSuperDAO;
import m4w4.entities.dao.TravelDAO;

public class App {
	private final static Logger log = LoggerFactory.getLogger(App.class);
	private final static JpaUtil<Card> crdJpa = new JpaUtil<Card>(Card.class);
	private final static JpaUtil<AuthorizedDealer> autJpa = new JpaUtil<AuthorizedDealer>(AuthorizedDealer.class);
	private final static JpaUtil<TicketMachine> macJpa = new JpaUtil<TicketMachine>(TicketMachine.class);
	private final static TicketSuperDAO tktSupJpa = new TicketSuperDAO();
	private final static TicketDAO tktJpa = new TicketDAO();
	private final static JpaUtil<Vehicle> vehJpa = new JpaUtil<Vehicle>(Vehicle.class);
	private final static JpaUtil<Route> rtJpa = new JpaUtil<Route>(Route.class);
	private final static TravelDAO trvJpa = new TravelDAO();

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
		Ticket tkt4 = newTicket(LocalDate.of(2022, 7, 30), mac);
		Ticket tkt5 = newTicket(LocalDate.of(2022, 7, 2), aut);
		Ticket tkt6 = newTicket(LocalDate.of(2022, 7, 14), mac2);
		Ticket tkt7 = newTicket(LocalDate.of(2022, 7, 11), aut2);

		Card crd = newCard(394530038999l, LocalDate.of(2022, 1, 10));
		Card crd2 = newCard(852655284600l, LocalDate.of(2021, 6, 15));
		Card crd3 = newCard(645633337720l, LocalDate.of(2022, 7, 2));
		Card crd4 = newCard(659036458844l, LocalDate.of(2022, 8, 9));

		SeasonTicket sea = newSeasonTkt(LocalDate.of(2022, 3, 4), Duration.MONTHLY, mac, 394530038999l);
		SeasonTicket sea2 = newSeasonTkt(LocalDate.of(2021, 5, 22), Duration.MONTHLY, aut2, 852655284600l);
		SeasonTicket sea3 = newSeasonTkt(LocalDate.now(), Duration.WEEKLY, mac2, 659036458844l);

		Vehicle veh = newVehicle(VType.BUS);
		Vehicle veh2 = newVehicle(VType.BUS);
		Vehicle veh3 = newVehicle(VType.BUS);
		Vehicle veh4 = newVehicle(VType.BUS);
		Vehicle veh5 = newVehicle(VType.TRAM);
		Vehicle veh6 = newVehicle(VType.TRAM);
		Vehicle veh7 = newVehicle(VType.TRAM);
		Vehicle veh8 = newVehicle(VType.TRAM);

		Route rt = newRoute("Valle Aurelia", "Tiburtina", "1h");
		Route rt2 = newRoute("Conciliazione", "Termini", "25m");
		Route rt3 = newRoute("Piazza Venezia", "Largo Pugliese", "45m");

		assignVehicleToRoute(1l, 2l);
		assignVehicleToRoute(2l, 3l);
		assignVehicleToRoute(3l, 3l);
		assignVehicleToRoute(4l, 2l);
		assignVehicleToRoute(5l, 3l);
		assignVehicleToRoute(6l, 2l);
		assignVehicleToRoute(7l, 1l);
		assignVehicleToRoute(8l, 3l);

		Travel trv = newTravel(1l, "30m");
		Travel trv2 = newTravel(1l, "21m");
		Travel trv3 = newTravel(3l, "38m");
		Travel trv4 = newTravel(3l, "50m");
		Travel trv5 = newTravel(3l, "43m");
		Travel trv6 = newTravel(6l, "25m");
		Travel trv7 = newTravel(7l, "56m");
		Travel trv8 = newTravel(7l, "1h 7m");
		assignVehicleToRoute(1l, 1l);
		Travel trv9 = newTravel(1l, "50m");

		validateTicket(1l, LocalDate.of(2022, 8, 2), 1l);
		validateTicket(2l, LocalDate.of(2022, 7, 28), 3l);
		validateTicket(3l, LocalDate.now(), 7l);
		validateTicket(4l, LocalDate.now(), 3l);
		validateTicket(5l, LocalDate.of(2022, 8, 11), 7l);
		validateTicket(6l, LocalDate.of(2022, 8, 10), 6l);

		//////////// TEST ////////////
		var seller = mac;
		var from = LocalDate.of(2022, 1, 30);
		var to = LocalDate.of(2022, 7, 30);
		log.info("=======================================================================");
		log.info("List of tickets emitted by {} from {} to {}", seller, from, to);
		tktSupJpa.getTicketsBySellerDuringPeriod(seller, from, to).forEach(x -> log.info(x.toString()));
		log.info("=======================================================================");

		log.info("Is season ticket valid? {}", isSeasonTicketValid(394530038999l));

		Vehicle testVeh = veh;
		Route testRt = rt2;
		log.info("=======================================================================");
		log.info("{} traveled through {} {} times", testVeh, testRt,
				trvJpa.getNumberOfTravelsOverRoute(testVeh, testRt));

		var from2 = LocalDate.of(2022, 8, 1);
		var to2 = LocalDate.now();
		log.info("=======================================================================");
		log.info("List of tickets validated from {} to {}", from2, to2);
		tktJpa.getValidatedTicketsByDate(from2, to2).forEach(x -> log.info(x.toString()));

		Vehicle testVeh2 = veh7;
		log.info("=======================================================================");
		log.info("List of tickets validated on {}", testVeh2);
		tktJpa.getValidatedTicketsByVehicle(testVeh2).forEach(x -> log.info(x.toString()));
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

	public static Ticket newTicket(LocalDate issueDate, TicketDealerSuper sll) {
		Ticket tkt = new Ticket();
		tkt.setIssueDate(issueDate);
		tkt.setTs(sll);
		tktSupJpa.save(tkt);
		return tkt;
	}

	public static SeasonTicket newSeasonTkt(LocalDate issueDate, Duration drt, TicketDealerSuper sll, Long cardNum) {
		SeasonTicket sea = null;
		var crd = crdJpa.getById(cardNum);
		if (crd instanceof Card) {
			sea = new SeasonTicket();
			sea.setIssueDate(issueDate);
			sea.setDuration(drt);
			sea.setExpirationDate(issueDate.plusDays(drt.getDuration()));
			sea.setTs(sll);
			crd.setSeaTkt(sea);
			tktSupJpa.save(sea);
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

	public static Vehicle newVehicle(VType t) {
		Vehicle veh = new Vehicle();
		veh.setVType(t);
		vehJpa.save(veh);
		return veh;
	}

	public static Route newRoute(String departureArea, String terminal, String expectedTravelTime) {
		Route rt = new Route();
		rt.setDepartureArea(departureArea);
		rt.setTerminal(terminal);
		rt.setExpectedTravelTime(expectedTravelTime);
		rtJpa.save(rt);
		return rt;
	}

	public static Travel newTravel(Long vehicleId, String travelTime) {
		Travel trv = null;
		var veh = vehJpa.getById(vehicleId);
		try {
			trv = new Travel();
			trv.setVehicle(veh);
			trv.setRoute(veh.getRoute());
			trv.setTravelTime(travelTime);
			trvJpa.save(trv);
		} catch (Exception ex) {
		}
		return trv;
	}

	public static boolean isSeasonTicketValid(Long cardNum) {
		var crd = crdJpa.getById(cardNum);
		return crd != null && !(LocalDate.now().isAfter(crd.getExpirationDate())
				&& LocalDate.now().isAfter(crd.getSeaTkt().getExpirationDate()));
	}

	public static void assignVehicleToRoute(Long vehicleId, Long routeId) {
		var veh = vehJpa.getById(vehicleId);
		var rt = rtJpa.getById(routeId);
		if (veh != null && rt != null) {
			veh.setRoute(rt);
			vehJpa.update(veh);
		}
	}

	public static void validateTicket(Long ticketId, LocalDate validationD, Long vehicleId) {
		var tkt = tktJpa.getById(ticketId);
		var veh = vehJpa.getById(vehicleId);
		if (tkt != null && veh != null && tkt.getValidationDate() == null) {
			tkt.setValidationDate(validationD);
			tkt.setValidationVehicle(veh);
			tktJpa.update(tkt);
		} else {
			log.error("Invalid ticket");
		}
	}

}
