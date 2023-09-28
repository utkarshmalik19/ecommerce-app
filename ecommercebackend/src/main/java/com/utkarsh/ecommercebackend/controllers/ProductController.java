package com.utkarsh.ecommercebackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.utkarsh.ecommercebackend.pojo.Product;
import com.utkarsh.ecommercebackend.pojo.ProductInput;
import com.utkarsh.ecommercebackend.services.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
@Autowired
private ProductService productService;
	@GetMapping("/test")
	public String test() {
		return "Working";
	}
	@PostMapping("/product/add")
	public ResponseEntity<String> addProduct(@RequestBody ProductInput productInput){
		Product product = new Product();
		product.setProductName(productInput.getProductName());
		product.setBrandName(productInput.getBrandName());
		product.setCategory(productInput.getCategory());
		product.setProductPrice(productInput.getProductPrice());
		product.setDescription(productInput.getDescription());
		//Getting review info
		product.setNumOfReviews(0);
		product.setRating(0);
		productService.addProduct(product);
		return ResponseEntity.ok("Product Added Successfully");
	}
	
	@PostMapping("/product/delete/{productCode}")
	public ResponseEntity<String> deleteProduct(@PathVariable int productCode){
		productService.deleteProduct(productCode);
		return ResponseEntity.ok("Product Deleted Successfully");
	}
	
	@GetMapping("/product/getall")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok(products);
	}
	
	@PostMapping("/product/search")
	public ResponseEntity<List<Product>> searchProduct(@RequestParam("searchValue") String searchValue){
		List<Product> products = productService.searchProducts(searchValue);
		return ResponseEntity.ok(products);
	}
}
