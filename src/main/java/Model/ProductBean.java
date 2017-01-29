package Model;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import Service.ProductService;

//@ManagedBean
//@RequestScoped
@Named
@SessionScoped
public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	ProductService productService;
	
	Product editProduct;
	private String productId;
	private String productName;
	private String productPrice;
	private String messageError;
	
	public ProductBean() {

	}
	

	public String getMessageError() {
		return messageError;
	}


	public void setMessageError(String messageError) {
		this.messageError = messageError;
	}

    
	public Product getEditProduct() {
		return editProduct;
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


	public String addProduct() {
		Product pro = new Product(this.productId, this.productName, this.productPrice);
	
		//	pro.setProductName(productBean.getProductName());
		//pro.setProductPrice(productBean.getProductPrice());

		// productService.addProduct(new
		// Product(this.productId,this.productName,this.productPrice));
		
		productService.addProduct(pro);
		return "view_product" +"?faces-redirect=true";
	}

	public List<Product> AllProductList() {
		return productService.ProductList();
	}
	
	public String deleteProduct(String productID){
		if(productService.DeleteProduct(productID))
		{
			return "view_product"; 
		}
		else{
			this.setMessageError("Product Id not found");
			return  "delete_product";
		}
	}
	public String edit(Product editProduct){
		this.editProduct = editProduct;
		return "edit_product";
	}
	public String updateProduct(){
		
		Product product = new Product(this.editProduct.getProductId(),this.editProduct.getProductName(),
				this.editProduct.getProductPrice());
		
		if(productService.EditProduct(product,this.editProduct.getProductId()))
		{
			return "view_product"; 
		}
		else{
			this.setMessageError("Product Id not found");
			return  "delete_product";
		}
	}

}
