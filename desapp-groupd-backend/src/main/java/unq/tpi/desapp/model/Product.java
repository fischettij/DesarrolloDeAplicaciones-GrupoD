package unq.tpi.desapp.model;

public class Product extends Entity {

	private String description;
	private Integer requiredPoints;
	private Integer stock;
	
	private static void assertStockAmountCantBeBelowZero(Integer amount){
		if (amount < 0) throw new RuntimeException("El stock no puede menor a 0"); 
	}
	
	private static void assertRequiredPointsAmountMustBeStrictlyPositive(Integer amount){
		if (amount < 1) throw new RuntimeException("Tiene que ser necesario al menos un punto");
	}
	
	public Product(String description, Integer requiredPoints, Integer stock){
		this.assertRequiredPointsAmountMustBeStrictlyPositive(requiredPoints);
		this.assertStockAmountCantBeBelowZero(stock);		
		
		this.description = description;
		this.requiredPoints = requiredPoints;
		this.stock = stock;	
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRequiredPoints() {
		return requiredPoints;
	}

	public void setRequiredPoints(Integer newRequiredPoints) {
		Product.assertRequiredPointsAmountMustBeStrictlyPositive(newRequiredPoints);
		this.requiredPoints = newRequiredPoints;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer newStock) {
		Product.assertStockAmountCantBeBelowZero(newStock);
		this.stock = newStock;
	}

	public void addMoreStock(Integer amountToAdd) {
		setStock(getStock() + amountToAdd);		
	}

	public void removeStock(Integer amountToRemove) {
		setStock(getStock()-amountToRemove);
	}
	
}
