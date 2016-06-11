package unq.tpi.desapp.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.services.ProductService;

@Path("/products")
public class ProductRest {

	private ProductService productService;
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService ) {
		this.productService = productService;
	}
	
	@GET
	@Path("/all")
	@Produces("application/json")
	public List<Product> getProducts() {
		return getProductService().retriveAll();
	}
}
