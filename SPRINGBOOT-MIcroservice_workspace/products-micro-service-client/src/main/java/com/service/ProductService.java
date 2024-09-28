package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Product;
import com.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public String storeProduct(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			return "Product id must be unique";
		}else {
			productRepository.save(product);
			return "Product details stored in db";
		}
	}
	public String updateProduct(Product product) {
		Optional<Product> result = productRepository.findById(product.getPid());
		if(result.isPresent()) {
			Product p = result.get();
			p.setPrice(product.getPrice());
			productRepository.saveAndFlush(p);
			return "Product details updated successfully";
		}else {
			return "Product not present";
		}
	}
	public String deleteProduct(int pid) {
		Optional<Product> result = productRepository.findById(pid);
		if(result.isPresent()) {
			Product p = result.get();
			productRepository.delete(p);;
			return "Product details deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public List<Product> findAll() {
		return productRepository.findAll();
	}
}
