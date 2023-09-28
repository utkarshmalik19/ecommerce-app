package com.utkarsh.ecommercebackend.servicesimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utkarsh.ecommercebackend.dao.ProductRepository;
import com.utkarsh.ecommercebackend.pojo.Product;
import com.utkarsh.ecommercebackend.services.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
@Autowired
private ProductRepository productRepository;
	@Override
	public void addProduct(Product product) {
		productRepository.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}

	@Override
	public List<Product> searchProducts(String searchValue) {
        if(searchValue == null || searchValue.isEmpty()) {
        	return (List<Product>) productRepository.findAll();
        }
		return productRepository.searchProducts(searchValue);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		
	}

}
