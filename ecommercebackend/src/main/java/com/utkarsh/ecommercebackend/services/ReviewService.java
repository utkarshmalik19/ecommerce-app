package com.utkarsh.ecommercebackend.services;

import java.util.List;

import com.utkarsh.ecommercebackend.pojo.Review;

public interface ReviewService {
	public void addReview(Review review);
	public List<Review> getProductReviews(Integer productId);
	public Long getReviewsCount();
	List<Review> getPendingReviews();
	void approveReview(int reviewId);
	void rejectReview(int reviewId);
}
