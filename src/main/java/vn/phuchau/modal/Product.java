package vn.phuchau.modal;

public class Product {
	private int productId;
	private String productName;
	private String Description;
	private int price;
	private int amount;
	private String images;
	private int stock;

	private Category category;

	public Product() {
	}

	public Product(int productId, String productName, String description, int price, int amount, String images,
			int stock, Category category) {
		super();
		this.productId = productId;
		this.productName = productName;
		Description = description;
		this.price = price;
		this.amount = amount;
		this.images = images;
		this.stock = stock;
		this.category = category;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getImages() {
		return images;
	}

	public void setImages(String images) {
		this.images = images;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", Description=" + Description
				+ ", price=" + price + ", amount=" + amount + ", images=" + images + ", stock=" + stock + ", category="
				+ category + "]";
	}

}
