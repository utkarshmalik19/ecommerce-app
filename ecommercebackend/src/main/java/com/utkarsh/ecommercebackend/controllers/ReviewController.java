package com.utkarsh.ecommercebackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.utkarsh.ecommercebackend.pojo.Review;
import com.utkarsh.ecommercebackend.services.ReviewService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ReviewController {
	@Autowired
	private ReviewService reviewService;

	@PostMapping("/reviews/addreview")
	public ResponseEntity<String> addReview(@RequestBody Review review) {
		try {
			review.setApproved(false);
			reviewService.addReview(review);
			return ResponseEntity.status(HttpStatus.CREATED).body("{\"message\": \"Review Added\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"message\": \"Review Added\"}");
		}

	}

	@GetMapping("/reviews/search/{productId}")
	public ResponseEntity<List<Review>> getProductReviews(@PathVariable Integer productId) {
		List<Review> reviews = reviewService.getProductReviews(productId);
		return ResponseEntity.ok(reviews);
	}

	@GetMapping("/reviews/pending")
	public ResponseEntity<List<Review>> getPendingReviews() {
		List<Review> pendingReviews = reviewService.getPendingReviews();
		return ResponseEntity.ok(pendingReviews);
	}

	@PostMapping("/reviews/approve/{reviewId}")
	public ResponseEntity<String> approveReview(@PathVariable int reviewId) {
		try {
			reviewService.approveReview(reviewId);
			return ResponseEntity.ok("{\"message\": \"Review Approved\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"message\": \"Failed to approve review\"}");
		}
	}

	@PostMapping("/reviews/reject/{reviewId}")
	public ResponseEntity<String> rejectReview(@PathVariable int reviewId) {
		try {
			reviewService.rejectReview(reviewId);
			return ResponseEntity.ok("{\"message\": \"Review Rejected\"}");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"message\": \"Failed to reject review\"}");
		}
	}
}
