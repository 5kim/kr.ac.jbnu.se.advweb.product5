package kr.ac.jbnu.se.advweb.product.model;

import java.awt.image.BufferedImage;

public class Product {
	private String productNumber;
	private String name;
	private float price;
	private String seller;
	private String description;	
	private int inventory;
	private int recommend;
	private BufferedImage image;
	private String category;
	
	public Product() {
	}
	

	public Product(String productNumber, String name, float price, String seller, String description, int inventory, String category) {
		this.productNumber = productNumber;
		this.name = name;
		this.price = price;
		this.seller = seller;
		this.description = description;
		this.inventory = inventory;
		this.category = category;
	}
	
	public Product(String productNumber, float price,int inventory) {
		this.productNumber = productNumber;
		this.price = price;
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

	public int getRecommend() {
		return recommend;
	}


	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	
	
	public BufferedImage getImage() {
		return image;
	}


	public void setImage(BufferedImage image) {
		this.image = image;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}

}