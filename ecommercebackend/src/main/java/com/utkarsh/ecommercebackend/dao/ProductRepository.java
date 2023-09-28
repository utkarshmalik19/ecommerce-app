package com.utkarsh.ecommercebackend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.utkarsh.ecommercebackend.pojo.Product;


public interface ProductRepository extends CrudRepository<Product, Integer>{

	@Query("SELECT p FROM Product p WHERE p.productName LIKE %:searchValue% OR p.brandName LIKE %:searchValue% OR p.category LIKE %:searchValue% ")
	List<Product> searchProducts(@Param("searchValue") String searchValue);
}
