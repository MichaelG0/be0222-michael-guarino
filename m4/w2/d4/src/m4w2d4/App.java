package m4w2d4;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class App {

	public static void main(String[] args) {
		List<Customer> customers = Arrays.asList( //
				new Customer(1, "Joe", 2), //
				new Customer(2, "John", 1), //
				new Customer(3, "Joseph", 2), //
				new Customer(4, "Jonathan", 3) //
		);
		List<Product> products1 = Arrays.asList( //
				new Product(1, "hghvh", "book", 12.99), //
				new Product(2, "ergvqe", "blu-ray", 120.99), //
				new Product(3, "ebewwev", "book", 100.01), //
				new Product(4, "avebw", "book", 130.50), //
				new Product(5, "avebw", "boys", 20.69) //
		);
		List<Product> products2 = Arrays.asList( //
				new Product(1, "dsdf", "boys", 33.57), //
				new Product(2, "dfsdf", "baby", 44.22), //
				new Product(3, "fdfd", "book", 11.77), //
				new Product(4, "efwww", "baby", 66.00), //
				new Product(5, "fewfef", "boys", 99.33) //
		);
		List<Product> products3 = Arrays.asList( //
				new Product(1, "ioio", "book", 7.09), //
				new Product(2, "uioku", "boys", 12.78) //
				);
		List<Product> products4 = Arrays.asList( //
				new Product(1, "tyhuyu", "boys", 31.20), //
				new Product(2, "yukuy", "baby", 16.00) //
				);
		List<Order> orders = Arrays.asList( //
				new Order(1, "dispatched", LocalDate.parse("2022-07-26"), LocalDate.parse("2022-08-01"), products1, customers.get(0)), //
				new Order(2, "delivered", LocalDate.parse("2022-07-22"), LocalDate.parse("2022-07-27"), products2, customers.get(1)), //
				new Order(3, "in-progress", LocalDate.parse("2022-07-27"), LocalDate.parse("2022-08-02"), products3, customers.get(2)), //
				new Order(4, "in-progress", LocalDate.parse("2022-07-27"), LocalDate.parse("2022-08-02"), products4, customers.get(3)) //
				);
		
		/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		List<Product> booksOver100 = products1.stream().filter(p -> p.getCategory().equals("book")).filter(p -> p.getPrice() > 100).collect(Collectors.toList());
		booksOver100.forEach(System.out::println);
		System.out.println("================================================================================");

		List<Order> babyOrders = orders.stream().filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals("baby"))).collect(Collectors.toList()) ;
		babyOrders.forEach(System.out::println);
		System.out.println("================================================================================");
		
		List<Product> discountForBoys = products2.stream().filter(p -> p.getCategory().equals("boys")).collect(Collectors.toList());
		discountForBoys.forEach(p -> p.discount(10));
		products2.forEach(System.out::println);
		System.out.println("================================================================================");
	}

}
