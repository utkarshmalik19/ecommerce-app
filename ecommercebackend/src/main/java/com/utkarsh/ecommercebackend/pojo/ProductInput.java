package com.utkarsh.ecommercebackend.pojo;

public class ProductInput {
	private String productName;
	private String brandName;
	private int productPrice;
	private String description;
	private String category;
	
	
	public ProductInput(String productName, String brandName, int productPrice, String description, String category) {
		super();
		this.productName = productName;
		this.brandName = brandName;
		this.productPrice = productPrice;
		this.description = description;
		this.category = category;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public int getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
}
