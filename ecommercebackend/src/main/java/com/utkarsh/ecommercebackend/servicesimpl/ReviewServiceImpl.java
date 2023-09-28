package com.utkarsh.ecommercebackend.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.ecommercebackend.dao.ReviewRepository;
import com.utkarsh.ecommercebackend.pojo.Review;
import com.utkarsh.ecommercebackend.services.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewRepository reviewRepository;

	public void addReview(Review review) {
		reviewRepository.save(review);
	}

	public List<Review> getProductReviews(Integer productId) {
		return reviewRepository.findProductByproductId(productId);
	}

	@Override
	public Long getReviewsCount() {
		return reviewRepository.count();
	}

	@Override
	public List<Review> getPendingReviews() {
		return reviewRepository.findByApprovedFalse();
	}

	@Override
	public void approveReview(int reviewId) {
		Review review = reviewRepository.findById(reviewId).orElseThrow(() -> new RuntimeException("Review not found"));
		review.setApproved(true);
		reviewRepository.save(review);
	}

	@Override
	public void rejectReview(int reviewId) {
		reviewRepository.deleteById(reviewId);
	}
}
