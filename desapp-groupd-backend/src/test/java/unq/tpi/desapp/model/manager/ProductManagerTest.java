package unq.tpi.desapp.model.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

import unq.tpi.desapp.builders.ProductManagerBuilder;
import unq.tpi.desapp.exception.NotFoundException;
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
		when(mockProduct.getId()).thenReturn(1l);
		ProductManager productManager = new ProductManagerBuilder().build();
		assertTrue(productManager.getProducts().isEmpty());

		productManager .add(mockProduct);
		assertEquals(productManager .getProducts().size(), 1);

		productManager.remove(1l);
		assertTrue(productManager.getProducts().isEmpty());
	}
	
	@Test
	public void testFind() throws NotFoundException{
		Product mockProduct = mock(Product.class);
		when(mockProduct.getId()).thenReturn(1l);
		ProductManager productManager = new ProductManagerBuilder().build();
		productManager.add(mockProduct);
		assertEquals(mockProduct, productManager.find(1l));		
	}
	
	@Test(expected= NotFoundException.class)
	public void testFindWithOutProduct() throws NotFoundException{
		Product mockProduct = mock(Product.class);
		when(mockProduct.getId()).thenReturn(2l);
		ProductManager productManager = new ProductManagerBuilder().build();
		productManager.add(mockProduct);
		productManager.find(1l);		
	}
}
