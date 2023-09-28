package com.utkarsh.ecommercebackend.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Review {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int reviewId;
	private int productId;
	private String heading;
	private int rating;
	private String review;
	private boolean approved;
	
	
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Review(int reviewId, int productId, String heading, int rating, String review, boolean approved) {
		super();
		this.reviewId = reviewId;
		this.productId = productId;
		this.heading = heading;
		this.rating = rating;
		this.review = review;
		this.approved = approved;
	}


	public int getReviewId() {
		return reviewId;
	}


	public void setReviewId(int reviewId) {
		this.reviewId = reviewId;
	}


	public int getProductId() {
		return productId;
	}


	public void setProductCode(int productId) {
		this.productId = productId;
	}


	public String getHeading() {
		return heading;
	}


	public void setHeading(String heading) {
		this.heading = heading;
	}


	public int getRating() {
		return rating;
	}


	public void setRating(int rating) {
		this.rating = rating;
	}


	public String getReview() {
		return review;
	}


	public void setReview(String review) {
		this.review = review;
	}


	public boolean isApproved() {
		return approved;
	}


	public void setApproved(boolean approved) {
		this.approved = approved;
	}
	
	
}
