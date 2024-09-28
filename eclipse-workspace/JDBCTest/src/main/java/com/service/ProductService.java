package com.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service								// Service layer annotation 
public class ProductService {
	//private ProductDao pd = new ProductDao();
	
	@Autowired
	ProductDao productDao;
	
	public String addProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Product price must be > 1000";
		}else if(productDao.storeProduct(product)>0) {
			return "Product details stored in database";
		}else {
			return "Product didn't store";
		}
	}
	public List<Product> findAllProducts(){
		List<Map<String, Object>> loList= productDao.retrieveAllProducts();
		List<Product> loP = new ArrayList<Product>();
		if(loList != null)
		{
			for(Map<String,Object> l:loList)
			{
				loP.add(new Product(Integer.parseInt( l.get("pid").toString()), l.get("pname").toString(), Float.parseFloat( l.get("price").toString())));
			}
		}
		return loP;
	}
//	public String deleteProduct(int pid) {
//		if(productDao.deleteProduct(pid)>0) {
//			return "Product removed successfully";
//		}else {
//			return "Product not present";
//		}
//	}
//	public String updatetProduct(Product product) {
//		if(productDao.updateProduct(product)>0) {
//			return "Product price updated successfully";
//		}else {
//			return "product not present";
//		}
//	}
}