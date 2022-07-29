package m4w2d4;

public class Product {
	private long id;
	private String name;
	private String category;
	private Double price;

	public Product(long id, String name, String category, Double price) {
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCategory() {
		return category;
	}

	public Double getPrice() {
		return price;
	}

	public void discount(int percentage) {
		this.price = Math.round(this.price * (100 - percentage)) / 100.0;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", category=" + category + ", price=" + price + "]";
	}
	
}
