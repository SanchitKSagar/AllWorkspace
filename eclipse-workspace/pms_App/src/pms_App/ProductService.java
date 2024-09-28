package pms_App;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ProductService {

	private List<Product> listOfProducts = new ArrayList<Product>();
	private ProductDao pd = new ProductDao();
	public String addProduct(Product product) {
		if(product.getPrice()<1000) {
			return "Product price must be > 1000";
		}else if(pd.storeProduct(product)>0) {
			return "Product details stored in database";
		}else {
			return "Product didn't store";
		}
	}

	public List<Product> findAllProducts(){
		return listOfProducts;
	}
	
	public String deleteProduct(int pid) {
		if(pd.deleteProduct(pid)>0) {
			return "Product removed successfully";
		}else {
			return "Product not present";
		}
	}
	public String updatetProduct(Product product) {
		if(pd.updateProduct(product)>0) {
			return "Product price updated successfully";
		}else {
			return "product not present";
		}
	}
}