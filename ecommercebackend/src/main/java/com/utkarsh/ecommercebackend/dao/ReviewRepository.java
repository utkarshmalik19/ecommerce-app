package com.utkarsh.ecommercebackend.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.utkarsh.ecommercebackend.pojo.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Integer>{
	List<Review> findProductByproductId(Integer productId);
	List<Review> findByApprovedFalse();
}
