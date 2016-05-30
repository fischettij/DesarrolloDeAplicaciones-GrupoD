package unq.tpi.desapp.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Test;

import unq.tpi.desapp.builders.ProductManagerBuilder;
import unq.tpi.desapp.model.Product;

public class ProductManagerTest {

	@Test
	public void testAddProduct() {
		Product mockProduct = mock(Product.class);
		ProductManager productManager = new ProductManagerBuilder().build();
		assertTrue(productManager.getProducts().isEmpty());

		productManager.add(mockProduct);

		assertEquals(productManager.getProducts().size(), 1);
	}
	
	@Test
	public void testRemoveProduct() throws Exception {
		Product mockProduct = mock(Product.class);
		ProductManager productManager = new ProductManagerBuilder().build();
		assertTrue(productManager.getProducts().isEmpty());

		productManager .add(mockProduct);
		assertEquals(productManager .getProducts().size(), 1);

		productManager.remove(mockProduct);
		assertTrue(productManager.getProducts().isEmpty());
	}
}
