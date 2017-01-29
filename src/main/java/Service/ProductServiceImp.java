package Service;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;

import Model.Product;
import Repository.RepositoryProduct;

public class ProductServiceImp implements ProductService, Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject 
	RepositoryProduct repositoryProduct;

	@Override
	public void addProduct(Product product) {
		repositoryProduct.addProduct(product);
		
	}

	@Override
	public List<Product> ProductList() {
		return repositoryProduct.ProductList();
	}

	@Override
	public Product SearchProduct(String productId) {
		return repositoryProduct.SearchProduct(productId);
	}

	@Override
	public boolean EditProduct(Product product,String productId) {
		
		return repositoryProduct.EditProduct(product,productId);
	}

	@Override
	public boolean DeleteProduct(String productId) {
		return repositoryProduct.DeleteProduct(productId);
	}

	
}
