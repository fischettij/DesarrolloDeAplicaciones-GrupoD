package unq.tpi.desapp.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import unq.tpi.desapp.model.Product;
import unq.tpi.desapp.services.ProductService;
import unq.tpi.desapp.services.request.GenericRequest;

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
	@Path("/all/{page}")
	@Produces("application/json")
	public List<Product> getProducts(@PathParam("page") final Integer page) {
		return getProductService().getProducts(page);
	}
	
	@POST
	@Path("/{productId}/purchaseBy/{userId}")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response purchaseProduct(@PathParam("userId") final Long userId, @PathParam("productId") final Long productId) {
		try {
			getProductService().purchaseProduct(userId, productId);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
	
	@POST
	@Path("/update/{productId}")
	@Produces("application/json")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateProduct(@PathParam("productId") final Long productId,GenericRequest<Product> request) {
		try {
			getProductService().updateProduct(productId,request);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().build();
		}
	}
}
