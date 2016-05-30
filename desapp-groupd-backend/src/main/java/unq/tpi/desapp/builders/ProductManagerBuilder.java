package unq.tpi.desapp.builders;

import java.util.ArrayList;
import java.util.List;

import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.model.manager.ProductManager;

public class ProductManagerBuilder {

	private List<Product> products = new ArrayList<Product>();
	
	public ProductManagerBuilder(){		
	}
	
	public ProductManager build(){
		return new ProductManager(products);
	}
}
