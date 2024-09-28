package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.bean.Product;
@Repository						// dao layer specific annotation 
public class ProductDao {

//	@Autowired
//	DataSource ds;
//	
//	public int storeProduct(Product product) {
//		try {
//		Connection con = ds.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
//	pstmt.setInt(1, product.getPid());
//	pstmt.setString(2, product.getPname());
//	pstmt.setFloat(3, product.getPrice());
//	return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
//	public int updateProduct(Product product) {
//		try {
//			Connection con = ds.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("update product set price = ? where pid=?");
//	pstmt.setFloat(1, product.getPrice());
//	pstmt.setInt(2, product.getPid());
//	return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
//	public int deleteProduct(int pid) {
//		try {
//			Connection con = ds.getConnection();
//	PreparedStatement pstmt = con.prepareStatement("delete from product where pid = ?");
//	pstmt.setInt(1, pid);
//	return pstmt.executeUpdate();
//		} catch (Exception e) {
//			System.err.println(e);
//			return 0;
//		}
//	}
//	
//	public List<Product> retrieveAllProducts() {
//		List<Product> listOfProducts = new ArrayList<Product>();
//		try {
//			Connection con = ds.getConnection();
//		Statement stmt = con.createStatement();
//		ResultSet rs = stmt.executeQuery("select * from product");
//		while(rs.next()) {
//			//System.out.println("display data from dao layer");
//			//System.out.println("pid is "+rs.getInt(1)+" pname "+rs.getString(2)+" price "+rs.getFloat(3));
//			Product p = new Product();
//			p.setPid(rs.getInt(1));
//			p.setPname(rs.getString(2));
//			p.setPrice(rs.getFloat(3));
//			listOfProducts.add(p);
//		}
//		return listOfProducts;
//			} catch (Exception e) {
//				System.err.println(e);
//			}
//		return null;
//	}
	
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public int storeProduct(Product product) {
	try {
	return jdbcTemplate.update("insert into product values(?,?,?)", product.getPid(),product.getPname(),product.getPrice());
	} catch (Exception e) {
		System.err.println(e);
		return 0;
	}
	}
	
	public List<Map<String, Object>> retrieveAllProducts() {
		try
		{
			List<Map<String, Object>> loList =  jdbcTemplate.queryForList("select * from product");
			return loList;
		}
		catch (Exception e)
		{
			System.err.println(e);
			return null;
		}
	}
	
}