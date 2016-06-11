package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;

import unq.tpi.desapp.model.Product;

public class ProductManager extends Manager {

	@JsonIgnore
	private List<Product> products;
	
	public ProductManager(){}
	
	public ProductManager(List<Product> someProducts){
		this.products = someProducts;
	}
	
	public void setProducts(List<Product> products){
		this.products = products;
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public void add(Product newProduct){
		products.add(newProduct);
	}
	
	@Override
	public String getManager() {
		return "ProductManager";
	}

	public void remove(Product productToRemove) {
		products.remove(productToRemove);
	}

}
