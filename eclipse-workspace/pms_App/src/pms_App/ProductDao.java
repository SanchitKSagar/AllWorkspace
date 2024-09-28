package pms_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ProductDao {
	public int storeProduct(Product product) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("driver loaded...");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgi_db", "root", "Password@1");
	PreparedStatement pstmt = con.prepareStatement("insert into product values(?,?,?)");
	pstmt.setInt(1, product.getPid());
	pstmt.setString(2, product.getPname());
	pstmt.setFloat(3, product.getPrice());
	return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int updateProduct(Product product) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgi_db", "", "");
	PreparedStatement pstmt = con.prepareStatement("update product set price = ? where pid=?");
	pstmt.setFloat(1, product.getPrice());
	pstmt.setInt(2, product.getPid());
	return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
	public int deleteProduct(int pid) {
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cgi_db", "", "");
	PreparedStatement pstmt = con.prepareStatement("delete from product where pid = ?");
	pstmt.setInt(1, pid);
	return pstmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			return 0;
		}
	}
}