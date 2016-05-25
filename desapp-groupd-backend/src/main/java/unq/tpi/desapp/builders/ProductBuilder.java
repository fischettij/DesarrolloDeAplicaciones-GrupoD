package unq.tpi.desapp.builders;

import unq.tpi.desapp.model.Product;

public class ProductBuilder {
	
	private String description = "$100 de nafta";
	private Integer requiredPoints = 15000;
	private Integer stock = 10;
	
	public ProductBuilder setDescription(String description) {
		this.description = description;
		return this;
	}
	public ProductBuilder setRequiredPoints(Integer requiredPoints) {
		this.requiredPoints = requiredPoints;
		return this;
	}
	public ProductBuilder setStock(Integer stock) {
		this.stock = stock;
		return this;
	}
	
	public Product build() {
		return new Product(description, requiredPoints, stock);
	}
}
