package unq.tpi.desapp.model.manager;

import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;

import unq.tpi.desapp.exception.NotFoundException;
import unq.tpi.desapp.model.Product;

public class ProductManager extends Manager {

	private static final long serialVersionUID = -7925313348966372887L;

	@JsonIgnore
	private List<Product> products;
	
	public ProductManager(){}
	
	public ProductManager(List<Product> someProducts){
		this.products = someProducts;
	}
	
	@JsonProperty
	public void setProducts(List<Product> products){
		this.products = products;
	}
	
	@JsonIgnore
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

	public void remove(Long productId) throws Exception {
		products.remove(this.find(productId));
	}

	public Product find(Long id) throws NotFoundException {
		for (Product product: this.getProducts()){
			if(product.getId().equals(id)){return product;}
		}
		throw new NotFoundException("No product");
	}
	
}
