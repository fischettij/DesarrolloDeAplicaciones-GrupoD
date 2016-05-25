package unq.tpi.desapp.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import unq.tpi.desapp.builders.ProductBuilder;

public class ProductTest {

	@Test
	public void testAccessing() {
		String description = "Un caramelo";
		Integer requiredPoints = 100;
		Integer stock = 500;
		
		Product producto = new ProductBuilder().setDescription(description).setRequiredPoints(requiredPoints).setStock(stock).build();
		
		assertEquals(producto.getDescription(), description);
		assertEquals(producto.getRequiredPoints(), requiredPoints);
		assertEquals(producto.getStock(), stock);
	}

	@Test
	public void testIncreaseStock() {
		Product product = new ProductBuilder().setStock(10).build();		
		assertEquals(product.getStock(),new Integer(10));
		
		product.addMoreStock(5);
		assertEquals(product.getStock(),new Integer(15));		
	}
	
	@Test
	public void testRemoveStock(){
		Product product = new ProductBuilder().setStock(15).build();		
		assertEquals(product.getStock(),new Integer(15));
		
		product.removeStock(5);
		assertEquals(product.getStock(),new Integer(10));		
	}
	
	@Test(expected = RuntimeException.class)
	public void testNewProdcutStockCantBeBelowZero(){
		new ProductBuilder().setStock(-1).build();		
	}
	
	@Test(expected = RuntimeException.class)
	public void testResultOfRemoveStockCantBeBelowZero(){
		Product product = new ProductBuilder().setStock(0).build();
		product.removeStock(1);	
	}
	
	@Test(expected = RuntimeException.class)
	public void testNewProdcutRequiredPointsMustBeStrictlyPositive(){
		new ProductBuilder().setRequiredPoints(0).build();	
	}
}
