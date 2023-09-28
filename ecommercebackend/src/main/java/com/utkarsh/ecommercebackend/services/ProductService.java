package com.utkarsh.ecommercebackend.services;

import java.util.List;

import com.utkarsh.ecommercebackend.pojo.Product;

public interface ProductService {
public void addProduct(Product product);
public void deleteProduct(int productId);
public void updateProduct(Product product);
public List<Product> getAllProducts();
public List<Product> searchProducts(String searchValue); 
}
