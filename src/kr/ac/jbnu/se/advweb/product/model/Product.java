package kr.ac.jbnu.se.advweb.product.model;

public class Product {
	private String productNumber;
	private String name;
	private float price;
	private String seller;
	private String description;	
	private int inventory;
	
	public Product() {
	}
	

	public Product(String productNumber, String name, float price, String seller, String description, int inventory) {
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
		this.seller = seller;
		this.description = description;
		this.inventory = inventory;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	
	public String getSeller() {
		return seller;
	}


	public void setSeller(String seller) {
		this.seller = seller;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public int getInventory() {
		return inventory;
	}


	public void setInventory(int inventory) {
		this.inventory = inventory;
	}
}