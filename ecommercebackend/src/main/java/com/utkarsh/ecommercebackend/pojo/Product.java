package com.utkarsh.ecommercebackend.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productId;
private String productName;
private String brandName;
private int productPrice;
private String description;
private String category;
private double rating;
private int numOfReviews;


public Product() {
	super();
	// TODO Auto-generated constructor stub
}
public Product(int productId, String productName, String brandName, int productPrice, String description,
		String category, double rating, int numOfReviews) {
	super();
	this.productId = productId;
	this.productName = productName;
	this.brandName = brandName;
	this.productPrice = productPrice;
	this.description = description;
	this.category = category;
	this.rating = rating;
	this.numOfReviews = numOfReviews;
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
public double getRating() {
	return rating;
}
public void setRating(double rating) {
	this.rating = rating;
}
public int getNumOfReviews() {
	return numOfReviews;
}
public void setNumOfReviews(int numOfReviews) {
	this.numOfReviews = numOfReviews;
}


}
