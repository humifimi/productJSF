package Model;

import java.io.Serializable;


public class Product implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String productId;
	private String productName;
	private String productPrice;

	public Product() {

	}

	public Product(String productId, String productName, String productPrice) {
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	
}
