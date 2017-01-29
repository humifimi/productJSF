package Repository;

import java.util.List;

import Model.Product;

public interface RepositoryProduct {
	
	public void addProduct(Product product);
	public List<Product> ProductList();
	public Product SearchProduct(String productId);
	public boolean EditProduct(Product product,String productId);
	public boolean DeleteProduct(String productId);
}
