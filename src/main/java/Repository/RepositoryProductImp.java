package Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import Model.Product;

public class RepositoryProductImp implements RepositoryProduct, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Map<String, Product> productList;

	public RepositoryProductImp() {
		productList = new TreeMap<>();
		productList.put("PD001", new Product("PD001","Apple","2000"));
		productList.put("PD002", new Product("PD002","Apple TV","200"));
	}

	@Override
	public void addProduct(Product product) {
		productList.put(product.getProductId(), product);
	}

	@Override
	public List<Product> ProductList() {
		return new ArrayList<Product>(productList.values());
	}

	@Override
	public Product SearchProduct(String productId) {
		return productList.containsKey(productId) ? productList.get(productId)
				: null;
	}

	@Override
	public boolean EditProduct(Product product,String productId) {

		Product editProduct = SearchProduct(productId);
		if (editProduct != null) {
			productList.remove(product.getProductId());
			productList.put(product.getProductId(), product);
			return true;
		}
		return false;

	}

	@Override
	public boolean DeleteProduct(String productId) {
		
		if (SearchProduct(productId) != null) {
			productList.remove(productId);
			return true;
		}
		return false;
	}

}
