package m4w3d5.app;

import java.time.LocalDate;

import m4w3d5.dao.LoanDao;
import m4w3d5.dao.ReadDao;
import m4w3d5.dao.UserDao;
import m4w3d5.entities.Book;
import m4w3d5.entities.Loan;
import m4w3d5.entities.Magazine;
import m4w3d5.entities.Periodicity;
import m4w3d5.entities.Read;
import m4w3d5.entities.User;

public class App {

	public static void main(String[] args) {
		populate();
		
		new ReadDao().getElementByIsbn("10293847");
		new ReadDao().getReadByPublicationYear(2022);
		new ReadDao().getBookByAuthor("neil gaiman");
		new ReadDao().getElementByTitle("ny");
		new LoanDao().getLoanByCardNumber(1234);
		new LoanDao().getExpiredLoans();
	}
	
	private static void populate() {
		User usr = newUser();
		User usr2 = newUser2();
		Read bk = newBook();
		Magazine mgz = newMagazine();
		newLoan(usr, mgz);
		newExpiredLoan(usr2, bk);
	}

	private static User newUser() {
		User usr = new User();
		usr.setName("Joe");
		usr.setSurname("Cocker");
		usr.setDateOfBirth(LocalDate.of(1955, 7, 1));
		usr.setCardNumber(1234);

		UserDao usrDao = new UserDao();
		usrDao.save(usr);
		return usr;
	}
	
	private static User newUser2() {
		User usr = new User();
		usr.setName("John");
		usr.setSurname("Cena");
		usr.setDateOfBirth(LocalDate.of(1976, 2, 12));
		usr.setCardNumber(5678);
		
		UserDao usrDao = new UserDao();
		usrDao.save(usr);
		return usr;
	}
	
	private static Book newBook() {
		Book bk = new Book();
		bk.setIsbn("10293847");
		bk.setTitle("American Gods");
		bk.setPublicationYear(2022);
		bk.setNumberOfPages(406);
		bk.setAuthor("Neil Gaiman");
		bk.setGenre("Fantasy");
		
		ReadDao rdDao = new ReadDao();
		rdDao.save(bk);
		return bk;
	}
	
	private static Magazine newMagazine() {
		Magazine mgz = new Magazine();
		mgz.setIsbn("94639010");
		mgz.setTitle("NYTimes");
		mgz.setPublicationYear(2022);
		mgz.setNumberOfPages(29);
		mgz.setPeriodicity(Periodicity.WEEKLY);
		
		ReadDao rdDao = new ReadDao();
		rdDao.save(mgz);
		return mgz;
	}
	
	private static void newLoan(User usr, Read rd) {
		Loan ln = new Loan();
		LocalDate lendDate = LocalDate.of(2022, 7, 20);
		
		ln.setUser(usr);
		ln.setBorrowedItem(rd);
		ln.setLendingDate(lendDate);
		ln.setReturnDeadline(lendDate);
		ln.setReturnDate(LocalDate.of(2022, 8, 5));
		
		LoanDao lnDao = new LoanDao();
		lnDao.save(ln);
	}
	
	private static void newExpiredLoan(User usr, Read rd) {
		Loan ln = new Loan();
		LocalDate lendDate = LocalDate.of(2022, 6, 8);
		
		ln.setUser(usr);
		ln.setBorrowedItem(rd);
		ln.setLendingDate(lendDate);
		ln.setReturnDeadline(lendDate);
		
		LoanDao lnDao = new LoanDao();
		lnDao.save(ln);
	}

}
